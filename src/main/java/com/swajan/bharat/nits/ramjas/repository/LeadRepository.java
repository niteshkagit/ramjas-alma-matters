package com.swajan.bharat.nits.ramjas.repository;

import com.swajan.bharat.nits.ramjas.data.entity.AlumniLeads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeadRepository extends JpaRepository<AlumniLeads,String> {

//    @Query("select a from momline_sch.alumni_leads a where a.admission_year <= 2010")
    List<AlumniLeads> findByAdmissionYearLessThanEqual(String admissionYear);
    List<AlumniLeads> findByAdmissionYearBetween(String start,String end);
}
