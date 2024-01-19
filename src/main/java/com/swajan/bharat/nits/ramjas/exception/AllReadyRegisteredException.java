package com.swajan.bharat.nits.ramjas.exception;

import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;

public class AllReadyRegisteredException extends RuntimeException {
    public AllReadyRegisteredException(EventRegistrationData registrationExistsData) {
        super(String.format("You have been already registered with given name: %s and phone %s"
                ,registrationExistsData.getFName(), registrationExistsData.getPhone()));
    }
}
