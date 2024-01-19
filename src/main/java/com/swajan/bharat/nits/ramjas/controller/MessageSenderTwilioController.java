package com.swajan.bharat.nits.ramjas.controller;


import com.swajan.bharat.nits.ramjas.service.EventRegistrationService;
import com.swajan.bharat.nits.ramjas.service.TwilioMessageService;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/2024/message/twilio")
public class MessageSenderTwilioController {

    @Autowired
    @Qualifier("TwilioSMSSender")
    TwilioMessageService twilioMessageService;

    @GetMapping("/send/registration/confirmation")
    public ResponseEntity<List<String>> sendMessageToAllRegistered(@RequestParam String  flagBit){

        System.out.println("flagBit : "+flagBit+ " and condition is "+("true".equalsIgnoreCase(flagBit)));
        System.out.println( ! flagBit.equals("true"));
        if("true".equalsIgnoreCase(flagBit) ||!  flagBit.equals("true") ){
            twilioMessageService.sendMessages();
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
