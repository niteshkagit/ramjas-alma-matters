package com.swajan.bharat.nits.ramjas.service.impl;

import com.swajan.bharat.nits.ramjas.constants.MessageTemplates;
import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.repository.EventRegistrationRepository;
import com.swajan.bharat.nits.ramjas.service.TwilioMessageService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TwilioSMSSender")
public class TwilioSMSSender implements TwilioMessageService {
    
    @Autowired
    EventRegistrationRepository registrationRepository;
    
    @Override
    public String sendMessage(String phoneNumber) {
        
        return null;
    }

    @Override
    public List<String> sendMessages() {
        System.out.println("sendMessages Called ...");
        List<String> sentMessagesList = new ArrayList<>();
        Twilio.init(MessageTemplates.ACCOUNT_SID,MessageTemplates.AUTH_TOKEN);

        List<EventRegistration> all = registrationRepository.findAll();

        System.out.println("Registration length : "+all.size());
        for (EventRegistration registration : all){
            String formattedMessage = String.format(MessageTemplates.welcomeMessageString,
                    registration.getSalutation(),
                    registration.getFName(),
                    registration.getContributionAmount(),
                    registration.getRegistrationDate(),
                    registration.getRegistrationId(),
                    "3PM Onwards",
                    "+919667126437"
            );



            String phone = registration.getCountryCode()+registration.getPhone();

            //"{\"1\":\"Shailesh Kumar\",\"2\":\"100\",\"3\":\"3pm Onwards\",\"4\":\"9667126437\"}"
            if(phone.contains("1947")){ // Test Condition
                System.out.println("Sending : "+formattedMessage);
                System.out.println("to  : "+phone);
                Message message = Message.creator(
                                new com.twilio.type.PhoneNumber(phone),
                                "MGdad1607b74de0d8924b1ff6e0c06f5ff",
                                formattedMessage)
                        .setContentSid("HXf770124e7d1e367677ce9fa205a3dea8")
                        .create();
                System.out.println("Message Sent to ["+registration.getRegistrationId()+"] with message id :"+message.getSid());
                sentMessagesList.add("Message Sent to ["+registration.getRegistrationId()+"] with message id :"+message.getSid());
            }



        }

        System.out.println("sendMessages Exit ...");
        return sentMessagesList;
    }
}
