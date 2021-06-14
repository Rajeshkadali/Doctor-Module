package com.cg.bmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer>{
	public List<Doctor> getBySpeciality(String speciality);
		
}


