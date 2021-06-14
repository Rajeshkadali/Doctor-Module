package com.cg.bmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.entities.Patient;
import com.cg.bmd.entities.Treatment;
import com.cg.bmd.service.ITreatmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/TreatmentDetails")
public class TreatmentController {
	
	@Autowired
	private ITreatmentService treatService;
	
	@PostMapping("/addTreatmentDetails")
	@ApiOperation("Treatment given by Doctor")
	public Treatment save(@RequestBody Treatment treatment) {
		return treatService.addTreatment(treatment);
		
	}
	
	@GetMapping("/fetchTreatmentDetails/{id}")
	@ApiOperation("TreatmentDetails fetched by id")
	
	public Treatment fetchTreatment(@PathVariable int id) {
		return treatService.fetchTreatmentById(id);
		
	}
	
	@GetMapping("/fetchAllTreatments")
	@ApiOperation("All Treatment Details")
	
	public List<Treatment> fetchAllTreatments(){
		return treatService.fetchAllTreatments();
		
	}
	

}
