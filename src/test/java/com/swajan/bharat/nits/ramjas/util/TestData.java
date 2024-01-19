package com.swajan.bharat.nits.ramjas.util;

import com.swajan.bharat.nits.ramjas.constants.MessageTemplates;
import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

public class TestData {

    public static EventRegistrationData createEventRegistrationData(){

        EventRegistrationData eventRegistrationData = new EventRegistrationData();
        eventRegistrationData.setFName("Nitesh");
        eventRegistrationData.setLName("Kashyap");
        eventRegistrationData.setMName("Ramkumar");
        eventRegistrationData.setPhone("9881717901");
        eventRegistrationData.setSubject("Statistics");
        eventRegistrationData.setBatch("2001-04");

        return eventRegistrationData;

    }

    //@Test
    public void callTwilioTemplateCreation(){
        // Create API Template and record content creation request ID from response
       // executeContentCreation();
    }

    String welcomeMessageString = "Hi,%s %s ! \uD83D\uDC4B \nThank you for confirming your attendance at our upcoming event, Ramjas Alumni Meet 2024!\n" +
            "We have received Rs.%s towards your registration.\n" +
            "We're excited to have you join us.\n" +
            "\nRequesting you to block your calender and per below Event Details:\n" +
            "\uD83D\uDCC5 Date: February 10th, 2024 (Saturday)\n\uD83D\uDD52 Time: %s\n" +
            "\uD83D\uDCCD Venue: Ramjas College Lawns. North campus. University Enclave, Delhi - 110007\n\n" +
            "We expect to please make aware your mates/Seniors and Juniors about date and request them to join you and us @College." +
            "Request them to confirm their participation through link https://forms.gle/3t7mr6rdMi4rZcmf6 \n" +
            "Like and share event page https://www.facebook.com/profile.php?id=61555657610207\n" +
            "If you have any questions or need further assistance, feel free to reach out to us at %s. We look forward to seeing you there!" +
            "\n\nRegards,\nPresident \nRamjas College Alumni Association.";

    @Test
    public void formatString(){

        welcomeMessageString = String.format(welcomeMessageString,"Dr.","Sudeepta Ghosh","100","3pm Onwards","+919667126437");
        System.out.println(welcomeMessageString);
    }

    @Test
    public void templateTesting(){
        String formattedMessageTemplate = String.format(MessageTemplates.welcomeMessageString,
                "{{1}}",
                "{{2}}",
                "{{3}}",
                "{{4}}",
                "{{5}}",
                "3PM Onwards",
                "+919667126437"
        );


        StringBuilder contentVariable = new StringBuilder();
        EventRegistration registration = new EventRegistration();
        registration.setSalutation("Mr.");
        registration.setFName("Nitesh Kashyap");
        registration.setContributionAmount(1001.0);
        registration.setRegistrationDate(new Date());
        registration.setRegistrationId("011NIT01ST44");

        contentVariable.append("\"{")
                .append("\\\"1\\\":").append( "\\\""+ registration.getSalutation()+"\\\"" ).append(",")
                .append("\\\"2\\\":").append( "\\\""+ registration.getFName()+"\\\"" ).append(",")
                .append("\\\"3\\\":").append( "\\\""+ registration.getContributionAmount()+"\\\"" ).append(",")
                .append("\\\"4\\\":").append( "\\\""+ registration.getRegistrationDate()+"\\\"" ).append(",")
                .append("\\\"5\\\":").append( "\\\""+ registration.getRegistrationId()+"\\\"" )
                .append("}\"");

        System.out.println(contentVariable.toString());
    }


    private void executeContentCreation() {
        String command = "curl -X POST 'https://content.twilio.com/v1/Content' \\\n" +
                "-H 'Content-Type: application/json' \\\n" +
                "-u ACe7984a48c86f322b8de55e7742078336:00b2c920a077c1a7fab7c9e60383bc44 \\\n" +
                "-d '{\n" +
                "    \"friendly_name\": \"confirmation_reply\",\n" +
                "    \"language\": \"en\",\n" +
                "    \"variables\": {\"1\":\"Shailesh Kumar\",\"2\":\"Ramjas Alumni Meet 2024\",,\"3\":\"February 10th, 2024 ( Saturday)\",\"4\":\": 3:00 pm onwards\",\"5\":\"Ramjas College Lawns. North campus. University Enclave, Delhi - 110007\",\"7\":\"9667126437\"},\n" +
                "    \"types\": {\n" +
                "        \"twilio/quick-reply\": {\n" +
                "                    \"body\": \"Hi, {{1}} \uD83D\uDC4B \\n Thank you for confirming your attendance at our upcoming event, {{2}}!\n" +
                "\t\t\t\t\t\t\tWe have received Rs.{{3}} from towards your registration.\n" +
                "\t\t\t\t\t\t\tWe're excited to have you join us.\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\tThank you again for confirming your attendance at our upcoming event, {{2}}! We're excited to have you join us.\\nEvent Details:\uD83D\uDCC5 Date: {{4}}\\n\uD83D\uDD52 Time: {{5}}\uD83D\uDCCD Venue: {{6}}\\n\\n. We expect to please make aware your mates/Senior and Juniors about datte and request them to join you and us @College. If you have any questions or need further assistance, feel free to reach out to us at {{7}}. We look forward to seeing you there!\\n\\nRegards, President \\n Ramjas College Alumni Association.\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "        \"twilio/text\": {\n" +
                "            \"body\": \"Hi, {{1}} \uD83D\uDC4B \\n Thank you for confirming your attendance at our upcoming event, {{2}}!\n" +
                "\t\t\t\t\t\t\tWe have received Rs.{{3}} from towards your registration.\n" +
                "\t\t\t\t\t\t\tWe're excited to have you join us.\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\tThank you again for confirming your attendance at our upcoming event, {{2}}! We're excited to have you join us.\\nEvent Details:\uD83D\uDCC5 Date: {{4}}\\n\uD83D\uDD52 Time: {{5}}\uD83D\uDCCD Venue: {{6}}\\n\\n. We expect to please make aware your mates/Senior and Juniors about datte and request them to join you and us @College. If you have any questions or need further assistance, feel free to reach out to us at {{7}}. We look forward to seeing you there!\\n\\nRegards, President \\n Ramjas College Alumni Association.\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "        }\n" +
                "    }\n" +
                "}'";

        try {
            Process process = Runtime.getRuntime().exec(command);
            System.out.println("Response : "+process.getInputStream().readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

