package com.swajan.bharat.nits.ramjas.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "alumni_leads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlumniLeads {
        @Id
        @Column(name = "email", nullable = false)
        private String email;
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
        @Column(name = "email_sent")
        private Boolean emailSent ;
        @Column(name = "sms_sent")
        private Boolean smsSent ;
        @Column(name = "whatsapp_sent")
        private Boolean whatsappSent ;
        @Column(name = "data_seeded_from")
        private String dataFileName ;
        @Column(name = "is_valid_data")
        private String invalidData ;
}
