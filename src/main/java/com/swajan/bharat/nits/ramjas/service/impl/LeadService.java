package com.swajan.bharat.nits.ramjas.service.impl;


import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import com.swajan.bharat.nits.ramjas.repository.LeadRepository;
import com.swajan.bharat.nits.ramjas.util.InvalidEmailRemover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public List<AlumniLeads> seedData(List<AlumniLeads> alumniLeadsList){
        for (AlumniLeads lead: alumniLeadsList) {
            leadRepository.save(lead);
        }

        return null;
    }

    public Set<String> markInvalidEmails(){

        Set<String> invalidEmails = InvalidEmailRemover.readInvalidEmails();
        Set<String> erroredEmails = new HashSet<>();
        for (String invalidEmail : invalidEmails){
            System.out.println("invalidEmail :"+invalidEmail);
            Optional<AlumniLeads> byId = null;
            try {
                byId = leadRepository.findById(invalidEmail);
                byId.get().setInvalidData("Yes");
                leadRepository.save(byId.get());
            } catch (NoSuchElementException e) {
                erroredEmails.add(invalidEmail);
                System.out.println("NoSuchElementException : " + e.getMessage());
            }
        }
        invalidEmails.removeAll(erroredEmails);

        return invalidEmails;
    }
}
