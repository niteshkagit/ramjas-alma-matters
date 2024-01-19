package com.swajan.bharat.nits.ramjas.service;

import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;
import org.springframework.stereotype.Service;

public interface EventRegistrationService {

    public EventRegistrationData getRegistration(String registrationId);
    public EventRegistrationData register(EventRegistrationData registration);
    public EventRegistrationData updateRegistration(EventRegistrationData registration);


}
