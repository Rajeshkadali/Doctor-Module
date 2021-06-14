package com.cg.bmd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="patient_table")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int patientId;
	@Column(name="PatientName")
	@Size(min=6,message="Patient name cannot be empty!!")
	@NotNull
	private String patientName;
	@Column(name="Mobile")
	@NotNull
	@Pattern(regexp="[0-9]{10}",message="Mobile number must contain ten digits!!")
	private String mobileNo;
	@Email
	@NotNull
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	@NotNull
	//@Size(min=5,max=15)
	@Pattern(regexp="[a-zA-Z0-9!@#$]{8}",message="Password must contain atleast one Captial key")
	private String password;
	@Column(name="BloodGroup")
	@NotNull
	//@Size(min=3,max=4)
	@Pattern(regexp="[ABO+-]{2,3}",message="Please enter valid blood group!")
	private String bloodGroup;
	@Column(name="Gender")
	@NotNull
	private String gender;
	@Column(name="Age")
	@NotNull
	@Max(value=3)
	@Pattern(regexp="[0-9]",message="Please enter valid Age!")
	private String age;
	@Column(name="Address")
	@NotNull
	private String address;
}
