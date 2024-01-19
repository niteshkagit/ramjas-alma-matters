package com.swajan.bharat.nits.ramjas.data.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EventRegistrationDataTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void convertToJSon(){
        EventRegistrationData registrationData = new EventRegistrationData();
        registrationData.setRegistrationId("test_reg_123");
        registrationData.setFName("Nitesh");
        registrationData.setLName("Kashyap");
        registrationData.setMName("Ramkumar");
        registrationData.setPhone("9881717901");

        ObjectMapper Obj = new ObjectMapper();
        try {
            // Converting the Java object into a JSON string
            String jsonStr = Obj.writeValueAsString(registrationData);
            // Displaying Java object into a JSON string
            System.out.println(jsonStr);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringParsing(){
        String parse = "01/6/2024 15:23:04|Kumar Rahul|9818323434|kumarrahul12@gmail.com|400615106628|https://drive.google.com/open?id=1RnHNzjnp2cDsjaPr2slfmnHgjHvwX3gn|1995-2000|Under Graduation and Post Graduation both|B.A. (Hons.) Political Science|Teaching |Ramjas College, DU|Associate Professor at Ramjas College |Delhi|42/3 Ramjas College Teachers Quarters, Chhatra Marg, Delhi 110007|1000|0|https://drive.google.com/open?id=1w1t984OMDKshTza-uZvyKy-ZK_A_iBBZ|yes|||";
        String[] parsed = parse.split("\\|");
        System.out.println(parsed.length);
        int i = 0;
        for (String data : parsed){
            System.out.println(i++ +" : "+data);
        }
    }
}