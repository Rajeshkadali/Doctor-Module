package com.cg.bmd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.DoctorNotFoundException;
import com.cg.bmd.repository.DoctorRepository;

@Service
public class IDoctorServiceImpl implements IDoctorService{
	
	@Autowired 
	private DoctorRepository docRepository; // dependency injection

	@Override
	public Doctor addDoctor(Doctor bean) {
		// TODO Auto-generated method stub
		return docRepository.save(bean);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		// TODO Auto-generated method stub
		return docRepository.save(bean);
	}

	@Override
	public void removeDoctor(int doctorId) throws DoctorNotFoundException {

		Optional<Doctor> doctor = docRepository.findById(doctorId);
		if (!doctor.isPresent())
			throw new DoctorNotFoundException();
		
		docRepository.deleteById(doctorId);

	}
	

	@Override
	public List<Doctor> getDoctorList() {
		return docRepository.findAll();
	}

/*	
	@Override
	public List<Doctor> getDoctorList(String speciality) {
		// TODO Auto-generated method stub
		return docRepository.findByName(speciality);
	}
*/
	@Override
	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException{

		Optional<Doctor> doctor = docRepository.findById(doctorId);
		if (!doctor.isPresent())
			throw new DoctorNotFoundException();
		return doctor.get();

	}

	
}
