package com.swajan.bharat.nits.ramjas.controller;


import com.swajan.bharat.nits.ramjas.service.EmailNotificationService;
import com.swajan.bharat.nits.ramjas.service.TwilioMessageService;
import com.swajan.bharat.nits.ramjas.service.impl.EmailNotificationGmailSmptService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/2024/message/email/payment")
public class EmailSenderController {

    @Autowired
    @Qualifier("EmailNotificationServiceSimplewayImpl")
    EmailNotificationService emailNotificationService;

    @Autowired
    EmailNotificationGmailSmptService smptService;

    @GetMapping
    public ResponseEntity<List<String>> sendMailToRegistered() throws MessagingException {

        List<String> strings = smptService.sendPaymentConfirmationMail();
        System.out.println("Mail sent to:"+strings);

        return new ResponseEntity<>(strings,HttpStatus.CREATED);
    }

    @PostMapping("/leads")
    public ResponseEntity<List<String>> sendMailToLeads() throws MessagingException {

        List<String> strings = smptService.sendMailtoLeads();
        System.out.println("Mail sent to leads:"+strings);
        return new ResponseEntity<>(strings,HttpStatus.CREATED);
    }


}
