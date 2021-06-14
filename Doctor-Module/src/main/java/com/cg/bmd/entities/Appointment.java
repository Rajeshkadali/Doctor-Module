package com.cg.bmd.entities;


//import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="appointment_table")
public class Appointment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Doctor doctor;
	
	//@Column(name = "patientname")
	//@NotNull
	//@Size(min = 2, message = "First Name should have mininum 2 characters!!")
	
	//LocalDate appointmentDate;
	
	@Column(name = "appointmentStatus")
	@NotNull
	private String appointmentStatus;
	
	@Column(name = "fname")
	@NotNull
	private String remark;
	@OneToOne(cascade = CascadeType.MERGE)
	private Patient patient;
	
}