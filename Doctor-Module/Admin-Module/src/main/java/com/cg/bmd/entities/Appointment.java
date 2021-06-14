/**
package com.cg.bmd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "appointment_table")
@Data
@NoArgsConstructor
public class Appointment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer appointmentid;
	
//@OneToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "cp_fk", referencedColumnName = "doctorId")
	
	@OneToOne
	private Doctor doctor;

	@OneToOne(cascade = CascadeType.ALL)
	private Patient patient;
	
	//@OneToOne(targetEntity = Patient.class, cascade = CascadeType.ALL)
	
	
	//LocalDate appointmentDate;
	
	@Column(name = "appointmentStatus")
	@NotNull
	String appointmentStatus;
	
	@Column(name = "remarks")
	@NotNull
	String remark;
	


}
**/