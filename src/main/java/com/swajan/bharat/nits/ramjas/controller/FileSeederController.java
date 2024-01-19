package com.swajan.bharat.nits.ramjas.controller;


import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;
import com.swajan.bharat.nits.ramjas.service.EventRegistrationService;
import com.swajan.bharat.nits.ramjas.service.impl.LeadService;
import com.swajan.bharat.nits.ramjas.util.LeadFileReader;
import com.swajan.bharat.nits.ramjas.util.RegistrationFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/2024/register/file")
public class FileSeederController {

    @Autowired
    private EventRegistrationService registrationService;

    @Autowired
    private LeadService leadService;

    /**
     * Rest api to
     * @param fileName
     * @return
     */
    @GetMapping
    public ResponseEntity<EventRegistrationData> seedFromCSV(@RequestParam String fileName){

        System.out.println("Call reached here...."+fileName);
        List<EventRegistrationData> registration = RegistrationFileReader.readFromFile(fileName);
        for (EventRegistrationData eventRegistration : registration){
            registrationService.register(eventRegistration);
        }

        //EventRegistrationData registeredData = registrationService.register(registrationData);
        return new ResponseEntity<>(registration.get(0), HttpStatus.CREATED);
    }

    @PostMapping("/leads")
    public ResponseEntity<AlumniLeads> seedLead(@RequestParam String fileName){

        System.out.println("Call reached here...."+fileName);
        List<AlumniLeads> leads = LeadFileReader.readFromFile(fileName);
        leadService.seedData(leads);


        //EventRegistrationData registeredData = registrationService.register(registrationData);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PostMapping("/mark/invalid")
    public ResponseEntity<Set<String>> markInvalid(){

        Set<String> invalidEmails = leadService.markInvalidEmails();


        //EventRegistrationData registeredData = registrationService.register(registrationData);
        return new ResponseEntity<>( invalidEmails,HttpStatus.CREATED);
    }

}
