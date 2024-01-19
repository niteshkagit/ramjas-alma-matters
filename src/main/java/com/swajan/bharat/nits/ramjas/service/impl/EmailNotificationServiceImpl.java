package com.swajan.bharat.nits.ramjas.service.impl;

import jakarta.mail.*;
import com.swajan.bharat.nits.ramjas.service.EmailNotificationService;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Service("EmailNotificationServiceImpl")
public class EmailNotificationServiceImpl implements EmailNotificationService {


    private String fromEmail = "nits.tiwary@gmail.com";
    private String password = "Target@24react";
    @Override
    public String sendEmailAll() {
        return null;
    }

    @Override
    public String sendEmail(String recipient) {


        try {
            Session session = createSession();

            Message message = new MimeMessage(session);
            System.out.println("to Email :"+recipient);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Mail Subject");
            String msg = "This is my first email using JavaMailer";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return recipient;
    }

    private Session createSession() throws NoSuchProviderException {
        jakarta.mail.Session session = jakarta.mail.Session.getInstance(configure(), new Authenticator() {
            @SneakyThrows
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String encoded = URLEncoder.encode(password, StandardCharsets.UTF_8.toString());
                System.out.println("fromEmail :"+fromEmail);
                System.out.println("encoded :"+encoded);
                return new PasswordAuthentication(fromEmail, encoded);
            }
        });
        session.getTransport().getURLName();
        return session;
    }

    private Properties configure() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        return prop;
    }

}
