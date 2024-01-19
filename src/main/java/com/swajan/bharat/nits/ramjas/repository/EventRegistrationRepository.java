package com.swajan.bharat.nits.ramjas.repository;

import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import com.swajan.bharat.nits.ramjas.data.entity.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration,String> {

    List<EventRegistration> findByEmailSent(String sentStatus);
}
