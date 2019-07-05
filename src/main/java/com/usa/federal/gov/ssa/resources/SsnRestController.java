package com.usa.federal.gov.ssa.resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usa.federal.gov.ssa.service.SsnRestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
public class SsnRestController {

	/**
	 *  This varible is for printing log..
	 */
	public static final Logger LOG = LogManager.getLogger(SsnRestController.class);
	
	

	/**
	 * This is Service class Reference..
	 */
	@Autowired
	private SsnRestService service;
    
	/**
	 * This method is used for get State name by sending ssn 
	 * @param ssn
	 * @return
	 */
	@GetMapping("/getstatebyssn/{ssn}")
	@ApiOperation("This Get method is for geting State name by SSN number")
	@ApiResponses({@ApiResponse(code = 204, message = "Bad request SSN num is not exist..")
	,@ApiResponse(code=404,message="Resource not found")})
	public String getStateNameBySsn(@PathVariable("ssn") final long ssn) {

	         

			return service.getStateNameBySsn(ssn);
	}

}
