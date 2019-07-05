package com.usa.federal.gov.ssa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usa.federal.gov.ssa.entity.SsnEnrollmentMasterEntity;
import com.usa.federal.gov.ssa.exception.RegistrationFailed;
import com.usa.federal.gov.ssa.model.SsnEnrollmentModel;
import com.usa.federal.gov.ssa.repository.SsnMasterRepository;
import com.usa.federal.gov.ssa.service.SsnGenerationService;
import com.usa.federal.gov.ssa.util.AppConstantsUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateSsnTest {
	
	 
	@Autowired
	private SsnMasterRepository ssnRepo;
	
	@Autowired
	private SsnGenerationService ssnGenService;
	
	@Test
	public void generateSsn() {
		
		SsnEnrollmentModel ssnModel=new SsnEnrollmentModel();
		                    ssnModel.setFirstName("Sumona");
		                    ssnModel.setLastName("singh");
		                    ssnModel.setDob("05/09/1990");
		                    ssnModel.setGender("Female");
		                    ssnModel.setState("Washingaton");
		                    ssnModel.setPhNo(1456589569);
		                     ssnModel.setImage(null);
		            assertEquals(AppConstantsUtils.SSN_GENERATED, ssnGenService.generateSsn(ssnModel));               
		   
		
	}
	
	
	@Test
	public void viewAllSsn() {
		
		assertNotNull(ssnGenService.getAllSsnDetails());
		
	}
	
	
	
}
