package com.cg.bmd.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="doctable")
public class Doctor {

@Id	
@GeneratedValue(strategy= GenerationType.AUTO)
public int doctorId;
  
@Column(name="doctorName")
@NotNull
@Size(min=4,message="please enter atleast 4 characters in your name")
public String doctorName;
public String location;
public String hospitalName;
@Column(name="mobileNo")
@NotNull
@Size(min=10,message="please enter 10 digits of your mobile number")
@Pattern(regexp="[0-9]{10}")
public String mobileNo;
@Column(name="email")
@Email
public String email;
@Column(name="password")
@NotNull
@Pattern(regexp="[a-zA-Z0-9!@#$]",message ="please enter atleast 1 capital,small letter and special characters !!!")
private String password;
@Column(name="ChargedPerVisit")
private double chargedPerVisit;
private String speciality;

}
