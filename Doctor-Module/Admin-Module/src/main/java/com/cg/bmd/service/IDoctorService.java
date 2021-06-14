package com.cg.bmd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.DoctorNotFoundException;

@Service
public interface IDoctorService {
	
	public Doctor addDoctor(Doctor bean);
	
	public Doctor updateDoctorProfile(Doctor bean);
	
	//public AvailabilityDates addAvaliability(AvaliabilityDates bean);
	
	//public AvailabilityDates updateAvaliability(AvaliabilityDates bean);

	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException;
	
	public void removeDoctor(int doctorId) throws DoctorNotFoundException;
	
	public List<Doctor> getDoctorList();

	
	//public List<Doctor> getDoctorList(String speciality);

}
