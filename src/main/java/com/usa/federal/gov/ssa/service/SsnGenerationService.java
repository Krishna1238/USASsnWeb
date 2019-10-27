package com.usa.federal.gov.ssa.service;

import java.util.List;

import com.usa.federal.gov.ssa.model.SsnEnrollmentModel;
import com.usa.federal.gov.ssa.model.StateModel;

public interface SsnGenerationService {
	
	public String saveState(StateModel state);
	public List<String> getAllStates();
	public String generateSsn( SsnEnrollmentModel ssnEnrollModel);
	public List<SsnEnrollmentModel> getAllSsnDetails();

}
