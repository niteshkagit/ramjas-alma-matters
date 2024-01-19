package com.swajan.bharat.nits.ramjas.util;

import com.swajan.bharat.nits.ramjas.constants.CourseCode;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationIDGeneratorTest {

    @Test
    void generateRegistrationID() throws ParseException {
        EventRegistrationData data = TestData.createEventRegistrationData();

        String id = RegistrationIDGenerator.generateRegistrationID(data);

        for (CourseCode cc : CourseCode.values()){
            System.out.println(cc.courseName);
        }
    }



    @Test
    void greetingOfTheDay() {
        String greeting = RegistrationIDGenerator.greetingOfTheDay();
        System.out.println(greeting);
    }
}