package com.usa.federal.gov.ssa.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.federal.gov.ssa.entity.SsnEnrollmentMasterEntity;
import com.usa.federal.gov.ssa.entity.StateMasterEntity;
import com.usa.federal.gov.ssa.exception.NoDataFound;
import com.usa.federal.gov.ssa.exception.NoSsnDetailsFound;
import com.usa.federal.gov.ssa.exception.NoStateFoundList;
import com.usa.federal.gov.ssa.exception.RegistrationFailed;
import com.usa.federal.gov.ssa.model.SsnEnrollmentModel;
import com.usa.federal.gov.ssa.model.StateModel;
import com.usa.federal.gov.ssa.repository.SsnMasterRepository;
import com.usa.federal.gov.ssa.repository.StatesMasterRepository;
import com.usa.federal.gov.ssa.util.AppConstantsUtils;

/**
 * This is service class to generate SSN for US Citizen
 * 
 * @author Krishna Murari
 *
 */
@Service
public class SsnGenerationServiceImpl implements SsnGenerationService {

	public static final Logger LOG = LogManager.getLogger(SsnGenerationServiceImpl.class);

	/**
	 * This is Repository is for save states in databse..
	 */
	@Autowired
	private StatesMasterRepository sateRepo;

	/**
	 * This is Repository class reference to save ssn register data..
	 */

	@Autowired
	private SsnMasterRepository ssnRepo;

	/**
	 * This method for saving State to data base..
	 */
	@Override
	public String saveState(StateModel stateModel) {

		LOG.debug("saveState method started");
		StateMasterEntity stateEntity = new StateMasterEntity();

		if (stateModel != null) {
			BeanUtils.copyProperties(stateModel, stateEntity);
			sateRepo.save(stateEntity);
			LOG.debug("save method ended..");
			LOG.info("state save sussfully..");
		} else {
			LOG.error("Something is wrong in stateModel data");
			throw new NoDataFound("No Data found in stateModel.");
		}

		return AppConstantsUtils.STATE_SAVED;
	}

	/**
	 * This method is for geting list of USA States..
	 * 
	 * @return listOfStates
	 */

	@Override
	public List<String> getAllStates() {

		LOG.debug("getAllStates method started");
		List<String> stateList = null;
		stateList = sateRepo.findAllSatesList();
		if (stateList != null) {
			LOG.debug("getAllstaters method finished");
			LOG.info("getAllState executed sussfully..");
			return stateList;
		} else {
			LOG.error("Problem in fetching states");
			throw new NoStateFoundList("Problem in fetching state list");

		}

	}

	/**
	 * This method for saving ssn form data and generate ssn
	 * 
	 * @return get registere ssn number..
	 */
	@Override
	public String generateSsn(SsnEnrollmentModel ssnEnrollModel) {

		SsnEnrollmentMasterEntity ssnEnrollEntity = new SsnEnrollmentMasterEntity();

		LOG.debug("generateSsn method started");
		if (ssnEnrollModel != null) {

			BeanUtils.copyProperties(ssnEnrollModel, ssnEnrollEntity);

			try {
				ssnEnrollEntity.setImage(ssnEnrollModel.getImage().getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/**
			 * Saveing ssnEnrollment data to db..
			 */
			ssnEnrollEntity = ssnRepo.save(ssnEnrollEntity);
			final long ssn = ssnEnrollEntity.getSsnNumber();

			/**
			 * Converting Long data to string
			 */
			String input = Long.toString(ssn);

			final String output = input.substring(0, 3) + "-" + input.substring(3, 5) + "-" + input.substring(5, 9);

			LOG.debug("generateSsn method ended.");
			LOG.info("Ssn generate method executed successfully..");
			return AppConstantsUtils.SSN_GENERATED + output;
		} else {
			LOG.error("Ssn generation failed");
			throw new RegistrationFailed("Ssn generation failed");

		}

	}

	/**
	 * This methos is for geting all ssn list details ..
	 * 
	 * @return list of all snn
	 */

	@Override
	public List<SsnEnrollmentModel> getAllSsnDetails() {

		LOG.debug("getAllSsnDetails method started");
		List<SsnEnrollmentMasterEntity> ssnListEntity = ssnRepo.findAll();

		List<SsnEnrollmentModel> ssnEnrollListModel = new ArrayList<>(ssnListEntity.size());
		/**
		 * For collection data check isEmpty in condition,and !null for single object
		 */
		if (!ssnListEntity.isEmpty()) {
			ssnListEntity.forEach(ssnEntity -> {
				SsnEnrollmentModel ssnModel = new SsnEnrollmentModel();
				BeanUtils.copyProperties(ssnEntity, ssnModel);
				ssnEnrollListModel.add(ssnModel);

			});
			LOG.debug("GetAllSnnDetails method ended.");
			LOG.info("getAllSsnDetails executed succesfully");
			return ssnEnrollListModel;

		} else {
			LOG.warn("No Ssn Details found");
			throw new NoDataFound("No Data  found in db");
		}

	}

}
