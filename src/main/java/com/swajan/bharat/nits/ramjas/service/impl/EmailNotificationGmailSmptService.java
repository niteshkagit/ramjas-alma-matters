package com.swajan.bharat.nits.ramjas.service.impl;


import com.swajan.bharat.nits.ramjas.constants.MessageTemplates;
import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.repository.EventRegistrationRepository;
import com.swajan.bharat.nits.ramjas.repository.LeadRepository;
import com.swajan.bharat.nits.ramjas.util.RegistrationIDGenerator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

;

@Service
public class EmailNotificationGmailSmptService  {

    //private String fromEmail = "nits.tiwary@gmail.com";
    private String fromEmail = "On Behalf of Ramjas Alumni Association<swajan.bharat@gmail.com>";
    private String ccEmail = "alumniassociation@ramjas.du.ac.in";

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    EventRegistrationRepository registrationRepository;

    @Autowired
    LeadRepository leadRepository;

    public List<String> sendPaymentConfirmationMail() throws MessagingException {
        List<String> emailSentList = new ArrayList<>();

        List<EventRegistration> pending = registrationRepository.findByEmailSent("No");

        System.out.println("Registration length : " + pending.size());
        for (EventRegistration registration : pending) {
            String formattedMessage = String.format(MessageTemplates.welcomeMessageStringHTML,
                    registration.getSalutation(),
                    registration.getFName(),
                    registration.getContributionAmount(),
                    registration.getRegistrationDate(),
                    registration.getRegistrationId(),
                    "3PM Onwards",
                    "+919667126437"
            );

            String subject = "Thanks ,"+registration.getSalutation()+" "+registration.getFName()
                    +"! for confirming your attendance for our upcoming event, Ramjas Alumni Meet - 2024!";
            String sentToEmail="test@mail.com";
            System.out.println("Mail Sent to :"+registration.getEmail());

            if("nits.tiwary@gmail.com".equals(registration.getEmail())){
              //   sentToEmail = sendEmail(registration.getEmail(),formattedMessage,subject);
            }
            sentToEmail = sendEmail(registration.getEmail(),formattedMessage,subject);
            emailSentList.add(sentToEmail);

            registration.setEmailSent("Yes");
            registrationRepository.save(registration);


        }
        return emailSentList;
    }

    public List<String> sendMailtoLeads() throws MessagingException {
        List<String> leads = new ArrayList<>();
        List<String> erroredEmails = new ArrayList<>();

        List<AlumniLeads> allLeads = leadRepository.findByAdmissionYearLessThanEqual("2013");

        System.out.println("Less than 2010 :"+allLeads.size());
        for (AlumniLeads lead : allLeads){
            if (lead.getEmailSent() != null || "Yes".equalsIgnoreCase(lead.getInvalidData())) //If already sent continue
                continue;
            String formattedMessage = String.format(MessageTemplates.leadsIntimationMail,
                    lead.getFName(),
                    RegistrationIDGenerator.greetingOfTheDay(),
                    "3PM Onwards",
                    "+919667126437"
            );

            String subject = "Dear "+ lead.getFName() +
                    " ! Ramjas College Alumni Meet-2024 is eagerly waiting for your presence !!";
            try {
                String sentMail = sendEmail(lead.getEmail(),formattedMessage,subject);

                if (sentMail != null){
                    lead.setEmailSent(Boolean.TRUE);
                    leadRepository.save(lead);
                }
                leads.add(sentMail+"-"+lead.getAdmissionYear());
                System.out.println("Mail Sent to :"+lead.getEmail());
            } catch (Exception e) {
                System.out.println("Errored Email :"+lead.getEmail());
                erroredEmails.add(lead.getEmail());
            }
        }
        System.out.println("Errored Emails :"+erroredEmails);
        System.out.println("Finally Total mails sent to # :"+leads.size());
        System.out.println("Mail Sent list and batch :"+leads);

        return leads;
    }



    private String sendEmail(String toEmail, String formattedMessage, String subject) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(fromEmail);
        helper.setTo(toEmail);
        helper.setCc(ccEmail);
        helper.setSubject(subject);
        helper.setText(formattedMessage,true);
        helper.addAttachment("RamjasAlumniMeet2024-Invitation.pdf",new File("src/main/resources/card/Ramjas-alumni-meet-invitation.pdf"));
        mailSender.send(mimeMessage);
        return toEmail;
    }


    public String sendEmail(String recipient) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("from@example.com");
        helper.setTo("to@example.com");
        helper.setSubject("Subject");
        helper.setText("Test mail");
        helper.setFrom(fromEmail);
        helper.setTo(recipient);
        helper.setSubject("Test Subject");
        mailSender.send(mimeMessage);
        return "";
    }

}
