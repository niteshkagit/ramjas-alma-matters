package com.swajan.bharat.nits.ramjas.controller;


import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;
import com.swajan.bharat.nits.ramjas.service.EventRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/2024/register/event")
public class EventRegistrationController {

    @Autowired
    private EventRegistrationService registrationService;

    /**
     * Rest api to
     * @param registrationData
     * @return
     */
    @PostMapping
    public ResponseEntity<EventRegistrationData> registerEvent(@RequestBody EventRegistrationData registrationData){

        EventRegistrationData registeredData = registrationService.register(registrationData);
        return new ResponseEntity<>(registeredData, HttpStatus.CREATED);
    }


}
