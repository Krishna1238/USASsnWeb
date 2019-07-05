package com.usa.federal.gov.ssa.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.federal.gov.ssa.exception.NoStateFound;
import com.usa.federal.gov.ssa.repository.SsnMasterRepository;

/**
 * This SsnRest api iml class..
 * @author Krishna Murari
 *
 */
@Service
public class SsnRestServiceIml implements SsnRestService {
	/**
	 * This Logger object for printing logs 
	 */
	
	public static final Logger LOG = LogManager.getLogger(SsnRestServiceIml.class);

	/**
	 * SsnMasterRepo ref varible
	 */
	@Autowired
	private SsnMasterRepository ssnRepo;
	/**
	 * This method for geting State name by Ssn..
	 * @return String state.
	 */
	
	@Override
	public String getStateNameBySsn(long ssn) {
		  /**
		   * callin dao method.
		   */
		LOG.debug("getStatebySsn method started.");
		String state=ssnRepo.getSateBySsn(ssn);
		    if(state!=null) {
		    	LOG.debug("getStatebySsn method ended..");
		    	LOG.info("getStateBySsn method executed successfully..");
		    	return state;
		    	
		    }else {
		    	
		    	throw new NoStateFound("Check your Ssn, No State is found with this ssn");
		    }
		
		
	}

}
