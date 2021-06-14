package com.cg.bmd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name ="doctor_table")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int doctorId;
	
	@Column(name = "doctorName")
	@NotNull
	@Size(min = 4 , message = "Please enter atleast 4 characters in your name ")
	public String doctorName;
	
	@Column(name = "speciality")
	@NotNull
	public String speciality;
	
	public String location;
	public String hospitalName;
	
	@Column(name = "mobileNo")
	@NotNull
	@Size(min = 10,message = " please enter 10 digits of your moblie number")
	@Pattern(regexp = "[0-9]{10}")
	public String mobileNo;
	
	@Column(name ="email")
	@Email
	public String email;
	
	@Column(name = "password")
	@NotNull
	//@Size()
	@Pattern(regexp = "^[a-zA-Z0-9!@#$]{8}", message = "Please use atleast 1 Capital,Small letters and Special characters !!!")
	private String password;
	
	@Column (name= "chargedPerVisit")
	//@NotNull
	//@Pattern(regexp = "[0-9]{3}")
	private double chargedPerVisit;
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admins;
	
	


}
