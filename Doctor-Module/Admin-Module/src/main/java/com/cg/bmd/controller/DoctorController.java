package com.cg.bmd.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.service.IDoctorService;
import com.cg.bmd.service.IPatientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Doctors")

public class DoctorController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPatientService patientService;

	@PostMapping("/saveDoctor")
	@ApiOperation(" Adding a Doctor Record")
	public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor) {
		logger.info("Adding a Doctor : " + doctor);
		Doctor doc = doctorService.addDoctor(doctor);
		return new ResponseEntity<>(doc, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateDoctor")
	@ApiOperation(" Updating a Doctor record")
	
	public Doctor update(@Valid @RequestBody Doctor doctor) {
		logger.info("Successfully updated  Doctordetails: " + doctor);
		return doctorService.updateDoctorProfile(doctor);
		
	}
	
	@GetMapping("/PatientsList/getByDoctor/{id}")
	
	public List<Patient> findByDoctor( @PathVariable Doctor id){
		return patientService.findPatientListByDoctor(id);
		
	}

	
	
}
