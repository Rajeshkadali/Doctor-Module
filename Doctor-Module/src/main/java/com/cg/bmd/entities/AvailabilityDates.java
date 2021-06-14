package com.cg.bmd.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Available_dates")
public class AvailabilityDates {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int availibilityId;
 @OneToOne(cascade=CascadeType.MERGE)
 private Doctor doctor;
 
 @Temporal(TemporalType.DATE)
 @JsonFormat(pattern="yyyy-MM-dd")
 private Date fromdate;
 
 @Temporal(TemporalType.DATE)
 @JsonFormat(pattern="yyyy-MM-dd")
 private Date enddate;
 
}
