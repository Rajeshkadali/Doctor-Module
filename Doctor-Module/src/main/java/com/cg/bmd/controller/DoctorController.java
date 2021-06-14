package com.cg.bmd.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.AvailabilityDates;
//import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.DoctorNotFoundException;

import com.cg.bmd.service.IDoctorService;
import com.cg.bmd.controller.DoctorController;
import com.cg.bmd.entities.Doctor;
//import com.cg.bmd.service.IDoctorService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/Doctors")
public class DoctorController {
	
	Logger logger = LoggerFactory.getLogger(DoctorController.class);

	 

    @Autowired
    private IDoctorService service;// CustomerService is a dependency of CustomerContoller
    
    
	@PostMapping("/save")  // adding doctor
    @ApiOperation("Add a Doctor Record")
    public ResponseEntity<Doctor> save(@Valid @RequestBody Doctor doctor) {
        logger.info("Adding a doctor : " + doctor);
        Doctor doc = service.addDoctor(doctor);
        return new ResponseEntity<>(doc, HttpStatus.CREATED);
    }
	
	@PutMapping("/update")     //updating Doctor profile
    @ApiOperation("Update an Existing Doctor Record")
    public Doctor update(@Valid @RequestBody Doctor doctor) {
        logger.info("Updating a Doctor!!");
        return service.updateDoctorProfile(doctor);
    }

	@PostMapping("/savethedates")
	@ApiOperation("Add Availibility date of doctor")
	public ResponseEntity<AvailabilityDates> addAvailabliityDateDoctor(@Valid @RequestBody AvailabilityDates dates) {
		// TODO Auto-generated method stub
		AvailabilityDates ad= service.addAvailability(dates);
		return new ResponseEntity<>(ad,HttpStatus.CREATED);
	}

	@PutMapping("/Updatedates")
	@ApiOperation("Update dates by doctor")
	public AvailabilityDates updateAvailabilityDateDoctor(@Valid @RequestBody AvailabilityDates dates) {
		// TODO Auto-generated method stub
		return service.updateAvailability(dates);
	}

	@GetMapping("{getdoctor}/{doctorId}")
	@ApiOperation("getting doctor details by id")
	public Doctor fetch(@PathVariable int doctorId) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		 return service.getDoctor(doctorId);
	}

    @DeleteMapping("/deleteDoctorById/{doctorId}")
    @ApiOperation("delete doctor details by id") //doctor should be return type
	public void deleteDoctor(@PathVariable int doctorId) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
	    service.removeDoctor(doctorId);
	}

	@GetMapping("/getlist")
	public List<Doctor> FindListDoctor()
	{
		// TODO Auto-generated method stub
		return service.getDoctorList();
	}
	@GetMapping("getDoctorBySpeciality/{speciality}")
	public List<Doctor> getDoctorBySpeciality(@PathVariable String speciality)
	{
		return service.getBySpeciality(speciality);
	}

}


