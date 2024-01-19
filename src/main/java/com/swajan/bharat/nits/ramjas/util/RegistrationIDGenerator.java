package com.swajan.bharat.nits.ramjas.util;

import com.swajan.bharat.nits.ramjas.constants.CourseCode;
import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RegistrationIDGenerator {

    public static String generateRegistrationID(EventRegistrationData data){
        StringBuilder defaultID = new StringBuilder();


        String batchYear  = extractAdmissionYear(data.getBatch());
        String  name= extractNameChars(data);
        String last2digit = extractLast2Digit(data.getPhone());
        String  subjectCode= extractSubjectCode(data.getSubject());


        defaultID.append(batchYear).append("1").append(name.toUpperCase()).append(last2digit)
                .append(subjectCode).append(generateHashValue(data));

        return (defaultID.toString()== "" )? UUID.randomUUID().toString() : defaultID.toString();
    }

    private static String generateHashValue(EventRegistrationData data) {
        int hashvalue = data.hashCode() % 100;
        if (hashvalue < 10){
            hashvalue += hashvalue + new Random().nextInt(90) + 10;
        }
        return String.valueOf(hashvalue);
    }

    /**
     * This method will be based on subject code mapping
     * @param subject
     * @return
     */
    public static String extractSubjectCode(String subject) {
        System.out.println("Subject:"+subject);
        for (CourseCode CC : CourseCode.values()){
            if (CC.getCourseName().equalsIgnoreCase(subject)){
                System.out.println(CC.getCourseCode());
                return CC.getCourseCode();
            }

        }
        return "OH"; //Default Other
    }

    private static String extractLast2Digit(String phone) {
        return phone.substring(phone.length() - 2);
    }



    private static String extractNameChars(EventRegistrationData data) {
        String fullName = data.getFName() + data.getLName() + data.getMName();
        fullName = fullName.replaceAll("[^a-zA-Z0-9]", "");
        return fullName.substring(0,3);
    }

    private static String extractAdmissionYear(String batch) {
        String[] batches = batch.split("-");
        if (batches.length > 0){
            return batches[0].substring(2);
        }
        return "47" ; //Default
    }

    public static EventRegistration mapToEventRegistration(EventRegistrationData registrationData) {
        EventRegistration eventRegistration = new EventRegistration();
        eventRegistration.setRegistrationId(registrationData.getRegistrationId());
        eventRegistration.setFName(registrationData.getFName());
        eventRegistration.setMName(registrationData.getMName());
        eventRegistration.setLName(registrationData.getLName());
        eventRegistration.setPhone(registrationData.getPhone());
        eventRegistration.setEmail(registrationData.getEmail());
        eventRegistration.setTransactionId(registrationData.getTransactionId());
        eventRegistration.setTransactionScreenshot(registrationData.getTransactionScreenshot());
        eventRegistration.setTransactionScreenshotUrl(registrationData.getTransactionScreenshotUrl());
        eventRegistration.setBatch(registrationData.getBatch());
        eventRegistration.setAdmissionYear(registrationData.getAdmissionYear());
        eventRegistration.setPassoutYear(registrationData.getPassoutYear());
        eventRegistration.setCourse(registrationData.getCourse());
        eventRegistration.setSubject(registrationData.getSubject());
        eventRegistration.setOccupation(registrationData.getOccupation());
        eventRegistration.setCurrentOrganization(registrationData.getCurrentOrganization());
        eventRegistration.setCurrentDesignation(registrationData.getCurrentDesignation());
        eventRegistration.setCurrentLocation(registrationData.getCurrentLocation());
        eventRegistration.setCurrentAddress(registrationData.getCurrentAddress());
        eventRegistration.setContributionAmount(registrationData.getContributionAmount());
        eventRegistration.setAdditionalMemberCount(registrationData.getAdditionalMemberCount());
        eventRegistration.setProfilePicture(registrationData.getProfilePicture());
        eventRegistration.setProfilePictureURL(registrationData.getProfilePictureURL());
        eventRegistration.setResidentStatus(registrationData.getResidentStatus());
        eventRegistration.setGenderStatus(registrationData.getGenderStatus());
        eventRegistration.setSalutation(registrationData.getSalutation());
        eventRegistration.setRegistrationDate(registrationData.getRegistrationDate());
        eventRegistration.setCreationDate(new Date());
        eventRegistration.setEmailSent(registrationData.getEmailSent());
        return eventRegistration;
    }

    public static EventRegistrationData mapToEventRegistrationData(EventRegistration registered) {
        return new EventRegistrationData(registered.getRegistrationId(),
                registered.getFName(),
                registered.getLName(),
                registered.getMName(),
                registered.getPhone(),
                registered.getCountryCode());
    }

    public static String greetingOfTheDay() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        String greeting = "Greetings of the day !";

        if(timeOfDay >= 0 && timeOfDay < 12){
            greeting = "Good Morning";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            greeting = "Good Afternoon";
        }else if(timeOfDay >= 16 && timeOfDay < 24){
            greeting = "Good Evening";
        }
        return greeting;
    }
}
