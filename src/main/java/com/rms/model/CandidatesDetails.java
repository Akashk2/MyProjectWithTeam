package com.rms.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CandidatesDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String candidateName;
	private String email;
	private String candidateId;
	private String phoneNumber;
	private String currentLocation;
	private String maritalStatus;
	@Column(name="created_on")
	private String createdOn;
	private String presentAddress;
	@Column(name="date_of_birth")
	private String dateOfBirth;
	@Column(name="last_updated_on")
	private String lastUpdatedOn;
	@Column(name = "uploaded_by")
	private String uploadedBy;
	@Column(name = "status")
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	private ProfessionalInformation professionalInformation;
	
	
}
