package com.usa.federal.gov.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.federal.gov.ssa.entity.SsnEnrollmentMasterEntity;

@Repository
public interface SsnMasterRepository extends JpaRepository<SsnEnrollmentMasterEntity,Serializable>{

	@Query(value="select STATE_NAME from SSN_MASTER WHERE SSN_NUMBER=?" ,nativeQuery=true)
	public String getSateBySsn( long ssn);

}
