package com.usa.federal.gov.ssa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.federal.gov.ssa.entity.StateMasterEntity;

@Repository
public interface StatesMasterRepository extends JpaRepository<StateMasterEntity, Serializable> {

	@Query(value="select STATE_NAME from USA_STATE_MASTER" ,nativeQuery=true)
	public List<String> findAllSatesList();
	
}
