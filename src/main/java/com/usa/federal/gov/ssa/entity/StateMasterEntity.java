package com.usa.federal.gov.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="USA_STATE_MASTER")
public class StateMasterEntity {
	
	@Id
	@Column(name="STATE_ID",length=2)
	private int stateId;
	@Column(name="STATE_NAME",length=20,nullable=false)
	private String stateName;
	@Column(name="STATE_CODE",length=4,nullable=false)
	private String stateCode;
	
}
