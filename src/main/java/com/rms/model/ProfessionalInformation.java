package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProfessionalInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String currentDesignation;
	private String currentCompany;
	private String totalYearOfExperience;
	private String currentCtc;
	private String expectedCtc;
	private String currentEmployementStatus;
	private String education;
	private String Industry;
	private String noticePeriod;
	private String preferdLocation;
	private String readyToRelocate;
	private String overseasExperience;
	private String havingPassport;
	private String passportValidity;
	private String visa;
	private String primarySkills;
	private String secondrySkills;
	
}
