package com.swajan.bharat.nits.ramjas.util;

import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import com.swajan.bharat.nits.ramjas.data.model.EventRegistrationData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LeadFileReader {

    final static String FormResponseDate = "MM/dd/yyyy hh:mm:ss";
    public static List<AlumniLeads> readFromFile(String fileName){
        String line = "";
        List<AlumniLeads> alumniLeads = new ArrayList<>();

        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data/"+fileName));
            int i =0;
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                AlumniLeads alumniLead = new AlumniLeads();
                if(fileName.equals("alumni-registration.txt")){
                    String[] leadsData = line.split("\\|");    // use comma as separator
                    alumniLead.setEmail(leadsData[4]);
                    setName(alumniLead,leadsData[1]);
                    alumniLead.setCourse(leadsData[2]);
                    alumniLead.setAdmissionYear(leadsData[3]);
                    alumniLead.setCurrentOrganization(leadsData[7]);
                    alumniLead.setCurrentDesignation(leadsData[8]);
                    alumniLead.setDataFileName(fileName);
                } else if (fileName.equals("ALUMNI-MEET-2019.txt")) {

                    String[] leadsData = line.split("\\|");    // use comma as separator
                    alumniLead.setEmail(leadsData[0]);
                    setName(alumniLead,leadsData[1]);
                    alumniLead.setPhone(leadsData[2]);
                    //alumniLead.setCourse(leadsData[2]);
                    alumniLead.setAdmissionYear(String.valueOf(Integer.parseInt(leadsData[3]) - 3));
                    alumniLead.setPassoutYear(leadsData[3]);
                    alumniLead.setCurrentOrganization(leadsData[5]);
                    alumniLead.setCurrentDesignation(leadsData[4]);
                    alumniLead.setCurrentAddress(leadsData[6]);
                    alumniLead.setDataFileName(fileName);

                }else if (fileName.equals("alumnidata2.txt")) {

                    String[] leadsData = line.split("\\|");    // use comma as separator
                    alumniLead.setEmail(leadsData[4]);
                    setName(alumniLead,leadsData[1]);
                    //alumniLead.setPhone(leadsData[2]);
                    //alumniLead.setCourse(leadsData[2]);
                    alumniLead.setAdmissionYear(leadsData[2]);
                    alumniLead.setCourse(leadsData[3]);
                    alumniLead.setDataFileName(fileName);

                }else if (fileName.equals("Chemistry-Department-Alumni-Meet.txt")) {

                    String[] leadsData = line.split("\\|");    // use comma as separator
                    alumniLead.setEmail(leadsData[1]);
                    setName(alumniLead,leadsData[2]);
                    alumniLead.setPhone(leadsData[5]);
                    alumniLead.setBatch(leadsData[3]);
                    alumniLead.setAdmissionYear(leadsData[3].split("-")[0]);
                    alumniLead.setPassoutYear(leadsData[3].split("-")[1]);
                    alumniLead.setCourse("B.Sc. (Hons.) Chemistry");
                    alumniLead.setCurrentDesignation(leadsData[6]);
                    alumniLead.setDataFileName(fileName);

                }else if (fileName.equals("Registrations1stAlumnimeet2022.txt")) {

                    String[] leadsData = line.split("\\|");    // use comma as separator
                    alumniLead.setEmail(leadsData[1]);
                    setName(alumniLead,leadsData[2]);
                    alumniLead.setPhone(leadsData[5]);
                    alumniLead.setAdmissionYear(String.valueOf(Integer.parseInt(leadsData[3]) -3));
                    alumniLead.setPassoutYear(String.valueOf(Integer.parseInt(leadsData[3])));
                    alumniLead.setCurrentDesignation(leadsData[4]);
                    alumniLead.setDataFileName(fileName);

                }


                alumniLeads.add(alumniLead);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return alumniLeads;
    }

    private static void setName(AlumniLeads alumniLead, String leadsDatum) {
        String[] nameParts = leadsDatum.split(" ");
        if (nameParts.length == 1){
            alumniLead.setFName(nameParts[0]);
        }else if (nameParts.length == 2){
            alumniLead.setFName(nameParts[0]);
            alumniLead.setLName(nameParts[1]);
        }else if (nameParts.length == 3){
            alumniLead.setFName(nameParts[0]);
            alumniLead.setMName(nameParts[1]);
            alumniLead.setLName(nameParts[2]);

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
