package com.swajan.bharat.nits.ramjas.service.impl;

import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;
import com.swajan.bharat.nits.ramjas.exception.AllReadyRegisteredException;
import com.swajan.bharat.nits.ramjas.exception.NoRegistrationFound;
import com.swajan.bharat.nits.ramjas.repository.EventRegistrationRepository;
import com.swajan.bharat.nits.ramjas.service.EventRegistrationService;
import com.swajan.bharat.nits.ramjas.util.RegistrationIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventRegistrationServiceImpl implements EventRegistrationService {
    @Autowired
    private EventRegistrationRepository registrationRepository;

    @Override
    public EventRegistrationData getRegistration(String registrationId) {
        Optional<EventRegistration> data = Optional.of(registrationRepository.findById(registrationId)
                .orElseThrow(() -> new NoRegistrationFound(registrationId)));
        return RegistrationIDGenerator.mapToEventRegistrationData(data.get());
    }

    @Override
    public EventRegistrationData register(EventRegistrationData registrationData) {
        if (registrationData.getRegistrationId() == "" || registrationData.getRegistrationId() == null){
            String generatedRegID = RegistrationIDGenerator.generateRegistrationID(registrationData);
            try {
                EventRegistrationData registrationExistsData = getRegistration(generatedRegID);
                if (registrationExistsData != null){
                    new AllReadyRegisteredException(registrationExistsData);
                }

            }catch (Exception e){
                if(e instanceof NoRegistrationFound){
                    System.out.println("No Registration found for: "+e.getMessage()+" | Continue with registration");
                    registrationData.setRegistrationId(generatedRegID);
                }
            }
        }
        EventRegistration eventRegistration = RegistrationIDGenerator.mapToEventRegistration(registrationData);
        EventRegistration registered = registrationRepository.save(eventRegistration);
        return RegistrationIDGenerator.mapToEventRegistrationData(registered);
    }

    @Override
    public EventRegistrationData updateRegistration(EventRegistrationData registration) {
        return null;
    }
}
