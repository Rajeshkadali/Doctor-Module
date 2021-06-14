package com.cg.bmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	 @Query("Select new com.cg.bmd.dto.PatientResponse(a.adminName , p.patientName) from Admin a Join a.patients p") 
	 

	public List<PatientResponse> getJoinInfo();
	 
	 @Query("Select new com.cg.bmd.dto.DoctorResponse( a.adminName ,  d.doctorName)from Admin a Join a.doctors d")
	
	 public List<DoctorResponse> getADJoinInfo();

}
