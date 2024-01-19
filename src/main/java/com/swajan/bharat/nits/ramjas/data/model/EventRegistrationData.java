package com.swajan.bharat.nits.ramjas.data.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventRegistrationData {
    private String registrationId;
    private String salutation;
    private String fName;
    private String lName;
    private String mName;
    private String phone = "999999999";
    private String countryCode = "+91";
    private String email ;
    private String batch ;
    private String admissionYear;
    private String passoutYear;
    private String course  ;
    private String subject ;
    private String occupation ;
    private String currentOrganization ;
    private String currentDesignation ;
    private String currentLocation ;
    private String currentAddress ;
    private String pin ;
    private String transactionId ;
    private Blob transactionScreenshot ;
    private String transactionScreenshotUrl ;
    private Double contributionAmount ;
    private int additionalMemberCount;
    private String residentStatus ;
    private String genderStatus ;
    private String profilePictureURL ;
    private Blob profilePicture ;
    private Date registrationDate;
    private Date creationDate;
    private Date updateDate;
    private String emailSent = null;

    public EventRegistrationData(String registrationId, String fName, String lName, String mName, String phone, String countryCode) {
    }
}
