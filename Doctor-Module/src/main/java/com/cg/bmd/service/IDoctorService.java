package com.cg.bmd.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.exception.DoctorNotFoundException;
@Service
public interface IDoctorService {
 public  Doctor addDoctor(Doctor bean);
 public  Doctor updateDoctorProfile(Doctor bean);
 public  AvailabilityDates addAvailability(AvailabilityDates bean);
 public  AvailabilityDates updateAvailability(AvailabilityDates bean);
 public  Doctor getDoctor(int doctorId) throws DoctorNotFoundException;
 public void removeDoctor(int doctorId) throws DoctorNotFoundException;
 public  List<Doctor> getDoctorList();
  
 public List<Doctor> getBySpeciality(String speciality);
	//public List<PatientResponse> getDPJoin();
	 //public List<AppointmentResponse> getDAJoin();
}
