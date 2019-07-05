package com.usa.federal.gov.ssa.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SsnEnrollmentModel {

	private long ssnNumber;

	@NotEmpty(message = "First name should not blank")
	@Size(min = 1, max = 15)
	private String firstName;

	@NotEmpty(message = "Last name should not blank")
	@Size(min = 1, max = 15)
	private String lastName;

	@NotEmpty(message = "Select date of birth")
	private String dob;
	@NotEmpty(message = "Select Gender")
	private String gender;
	@NotNull(message = "Enter mobile no.")
	private long phNo;
	@NotEmpty(message = "State should not empty")
	private String state;
	
	private MultipartFile image;
	@CreationTimestamp
	private Date createDate;
	@UpdateTimestamp
	private Date updateDate;

}
