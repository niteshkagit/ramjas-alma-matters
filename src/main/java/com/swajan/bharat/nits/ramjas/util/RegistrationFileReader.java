package com.swajan.bharat.nits.ramjas.util;

import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationFileReader {

    final static String FormResponseDate = "MM/dd/yyyy hh:mm:ss";
    public static List<EventRegistrationData> readFromFile(String fileName){
        String line = "";
        List<EventRegistrationData> registrationList = new ArrayList<>();

        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data/"+fileName));
            int i =0;
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                EventRegistrationData registration = new EventRegistrationData();
                String[] registrationData = line.split("\\|");    // use comma as separator
                registration.setRegistrationDate(new SimpleDateFormat(FormResponseDate).parse(registrationData[0]));
                setName(registration,registrationData[1]);
                registration.setPhone(registrationData[2]);
                registration.setEmail(registrationData[3]);
                registration.setTransactionId(registrationData[4]);
                registration.setTransactionScreenshotUrl(registrationData[5]);
                registration.setBatch(registrationData[6]);
                registration.setAdmissionYear(evaluateAdmissionYr(registrationData[6]));
                registration.setPassoutYear(evaluatePassingOutYr(registrationData[6]));
                registration.setCourse(registrationData[7]);
                registration.setSubject(registrationData[8]);
                registration.setOccupation(registrationData[9]);
                registration.setCurrentOrganization(registrationData[10]);
                registration.setCurrentDesignation(registrationData[11]);
                registration.setCurrentLocation(registrationData[12]);
                registration.setCurrentAddress(registrationData[13]);
                registration.setContributionAmount(Double.valueOf(registrationData[14]));
                registration.setAdditionalMemberCount(Integer.parseInt(registrationData[15]));
                registration.setProfilePictureURL(registrationData[16]);
                registration.setResidentStatus(registrationData[17]);
                registration.setGenderStatus(registrationData[18]);
                registration.setSalutation(registrationData[19]);
                registration.setEmailSent("No");
                registrationList.add(registration);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return registrationList;
    }

    private static void setName(EventRegistrationData registration, String registrationDatum) {
        String[] nameParts = registrationDatum.split(" ");
        if (nameParts.length == 1){
            registration.setFName(nameParts[0]);
        }else if (nameParts.length == 2){
            registration.setFName(nameParts[0]);
            registration.setLName(nameParts[1]);
        }else if (nameParts.length == 3){
            registration.setFName(nameParts[0]);
            registration.setMName(nameParts[1]);
            registration.setLName(nameParts[2]);

        }
    }

    private static String evaluateAdmissionYr(String registrationDatum) {
        String[] years = registrationDatum.split("-");
        return years[0];
    }
    private static String evaluatePassingOutYr(String registrationDatum) {
        String[] years = registrationDatum.split("-");
        if (years.length > 1)
            return years[1];
        return "";
    }

}
