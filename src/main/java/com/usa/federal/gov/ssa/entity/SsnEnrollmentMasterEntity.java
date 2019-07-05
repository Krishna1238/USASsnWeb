package com.usa.federal.gov.ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "SSN_MASTER")
public class SsnEnrollmentMasterEntity {

	@Id
	@SequenceGenerator(sequenceName = "SSN", name = "ssn_master", allocationSize = 1, initialValue = 888854321)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssn_master")
	@Column(name = "SSN_NUMBER")
	private long ssnNumber;
	@Column(name = "FIRST_NAME", nullable = false, length = 15)
	private String firstName;
	@Column(name = "LAST_NAME", length = 15, nullable = false)
	private String lastName;
	@Column(name = "DOB", nullable = false, length = 12)
	private String dob;
	@Column(name = "GENDER", nullable = false, length = 6)
	private String gender;
	@Column(name = "PHONE_NO", nullable = false, length = 12)
	private long phNo;
	@Column(name = "STATE_NAME", nullable = false, length = 20)
	private String state;
	@Column(name = "CITIZEN_IMAGE", nullable = false)
	@Lob
	private byte[] image;
	@Column(name = "SSN_CREATION_DATE", nullable = false, length = 12)
	@CreationTimestamp
	private Date createDate;
	@Column(name = "SSN_UPDATE_DATE", length = 12)
	@UpdateTimestamp
	private Date updateDate;

}
