package com.usa.federal.gov.ssa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usa.federal.gov.ssa.exception.NoStateFound;
import com.usa.federal.gov.ssa.service.SsnRestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckStateNameBySsnTest {

	@Autowired
	private SsnRestService ssnService;

	@Test
	public void checkStateName() {

		assertEquals("Alabama", ssnService.getStateNameBySsn(888854321));
		

	}
	@Test
	
	public void checkSsnByRongSate() {
		
		assertNotEquals("washingoton", ssnService.getStateNameBySsn(888854321));
	}
	
	@Test(expected=NoStateFound.class)
	public void checkStateByRongSsn() {
		
		assertNull( ssnService.getStateNameBySsn(45566555));
		
	}
	

}
