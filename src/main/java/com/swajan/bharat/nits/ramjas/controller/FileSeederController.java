package com.swajan.bharat.nits.ramjas.controller;


import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;
import com.swajan.bharat.nits.ramjas.repository.EventRegistrationRepository;
import com.swajan.bharat.nits.ramjas.service.EventRegistrationService;
import com.swajan.bharat.nits.ramjas.service.impl.LeadService;
import com.swajan.bharat.nits.ramjas.util.LeadFileReader;
import com.swajan.bharat.nits.ramjas.util.RegistrationFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/2024/register/file")
public class FileSeederController {

    @Autowired
    private EventRegistrationService registrationService;

    @Autowired
    private EventRegistrationRepository registrationRepository;

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
        List<EventRegistration> all = registrationRepository.findAll();
        Set<String> emailSet = new HashSet<>();
        all.stream().forEach(data -> {
            emailSet.add(data.getEmail());
        });
        for (EventRegistrationData eventRegistration : registration){
            if (emailSet.contains(eventRegistration.getEmail())){
                //registrationService.register(eventRegistration);
                System.out.println("Exiting Data: "+eventRegistration.getEmail());
            }else {
                registrationService.register(eventRegistration);
                System.out.println("Added Data: "+eventRegistration.getEmail());
            }

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
