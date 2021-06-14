package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.exception.DoctorNotFoundException;
import com.cg.bmd.repository.AvailabilityRepository;
import com.cg.bmd.repository.IDoctorRepository;
import com.cg.bmd.service.IDoctorServiceImpl;

@Service
public class IDoctorServiceImpl implements IDoctorService{

	Logger logger = LoggerFactory.getLogger(IDoctorServiceImpl.class);
    @Autowired
	private IDoctorRepository repository;
    
    @Autowired
    private AvailabilityRepository arepository;

	@Override
	public Doctor addDoctor(Doctor bean) {
		// TODO Auto-generated method stub
		logger.info("Inside addDoctor method of IDoctorServiceImp1");
		return repository.save(bean);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		// TODO Auto-generated method stub
		return repository.save(bean);
	}

     @Override
	public AvailabilityDates addAvailability(AvailabilityDates bean) {
		// TODO Auto-generated method stub
		
		return arepository.save(bean);
	}

	@Override
	public AvailabilityDates updateAvailability(AvailabilityDates bean) {
		// TODO Auto-generated method stub
		return arepository.save(bean);
	}

	@Override
	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException{
		// TODO Auto-generated method stub

		Optional<Doctor>  doctor = repository.findById(doctorId);
    	if(!doctor.isPresent())
    	{
    		throw new DoctorNotFoundException();
    	}
    	 return doctor.get();
    }
	

    @Override  // instead of Doctor void is used
	public void removeDoctor(int doctorId) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
    	Optional<Doctor>  doctor = repository.findById(doctorId);
    	if(!doctor.isPresent())
    	{
    		throw new DoctorNotFoundException();
    	}
    	 repository.deleteById(doctorId);
    }
	

	@Override
	public List<Doctor> getDoctorList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

    /*@Override
	public List<Doctor> getDoctorList(String speciality) {
		// TODO Auto-generated method stub
		return repository.getDoctorList(speciality);
	}*/
	/*@Override
	public List<PatientResponse> getDPJoin() {
		
		logger.info("List of Doctor-Patients !!!!");
		return repository.getDPJoin();
	}*/
	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		
		logger.info("Fetched list by DoctorSpeciality!!! ");
		return repository.getBySpeciality(speciality);
	}
	/*@Override
	public List<AppointmentResponse> getDAJoin() {
		logger.info("Displays List of Doctor-Appointments");
		return repository.getDAJoin();
	}*/


}
