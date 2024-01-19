package com.swajan.bharat.nits.ramjas.data.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "event_registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventRegistration {

    @Id
    @Column(name = "registration_id", nullable = false)
    private String registrationId;
    @Column(name = "salutation")
    private String salutation;
    @Column(name = "first_name")
    private String fName;
    @Column(name = "last_name")
    private String lName;
    @Column(name = "middle_Name")
    private String mName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "country_code")
    private String countryCode = "+91";
    @Column(name = "email")
    private String email ;
    @Column(name = "batch") //formatting required
    private String batch ;
    @Column(name = "admission_year")
    private String admissionYear;
    @Column(name = "passout_year")
    private String passoutYear;
    @Column(name = "course")
    private String course  ;
    @Column(name = "subject")
    private String subject ;
    @Column(name = "occupation")
    private String occupation ;
    @Column(name = "current_organization")
    private String currentOrganization ;
    @Column(name = "current_designation")
    private String currentDesignation ;
    @Column(name = "current_location")
    private String currentLocation ;
    @Column(name = "current_address")
    private String currentAddress ;
    @Column(name = "pin")
    private String pin ;
    @Column(name = "transaction_id")
    private String transactionId ;
    @Column(name = "transaction_Screenshot")
    private Blob transactionScreenshot ;
    @Column(name = "transaction_Screenshot_url")
    private String transactionScreenshotUrl ;
    @Column(name = "contribution_amount")
    private Double contributionAmount ;
    @Column(name = "additional_member")
    private int additionalMemberCount ;
    @Column(name = "resident_status")
    private String residentStatus ;
    @Column(name = "gender_status")
    private String genderStatus ;
    @Column(name = "profile_picture_url")
    private String profilePictureURL ;
    @Column(name = "profile_picture")
    private Blob profilePicture ;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "creation_date")
    private Date creationDate = new Date();
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "confirmation_mail")
    private Boolean confirmationMail;
    @Column(name = "email_sent")
    private String emailSent;

}
