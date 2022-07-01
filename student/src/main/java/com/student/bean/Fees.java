package com.student.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Fees {
	@Id
	@GeneratedValue
	private int id;
	private Double ammount;
	private String holderName;
	@ManyToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;

}
