package com.usa.federal.gov.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.federal.gov.ssa.config.AppConfig;
import com.usa.federal.gov.ssa.exception.NoDataFound;
import com.usa.federal.gov.ssa.exception.RegistrationFailed;
import com.usa.federal.gov.ssa.model.SsnEnrollmentModel;
import com.usa.federal.gov.ssa.model.StateModel;
import com.usa.federal.gov.ssa.service.SsnGenerationService;
import com.usa.federal.gov.ssa.util.AppConstantsUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * This Controller is for Registering Ssn for US Citizen..
 */
@Controller
@Api
public class SsnEnrollmentController {

	public static final Logger LOG = LogManager.getLogger(SsnEnrollmentController.class);

	/*
	 * This is service class reference variable..to call service method...
	 * 
	 */
	@Autowired
	private SsnGenerationService ssnService;

	/**
	 * This class is for reading String message from YML file
	 */
	@Autowired
	private AppConfig appConfig;

	/**
	 * This method th show SSN Enrollment form for US Citizen..
	 * 
	 * @param model
	 * @return String as Logical View name That JSP page..
	 */

	@GetMapping("/ssnregistration")
	@ApiOperation("This Get method is for SSN Registration")
	public String ssnRegistration(Model model) {
		/**
		 * The add attribute key must be same as modelAttribute in JSP page
		 */
		model.addAttribute("ssnModelAttribute", new SsnEnrollmentModel());
		/**
		 * This method is to for sending gender and states on jsp..
		 */
		initialization(model);

		return AppConstantsUtils.SSN_REGISTRATION_VIEW;
	}

	/**
	 * In this method form submission data will captured and Generate Ssn
	 * 
	 * @param ssnEnrollModel
	 * @param errorResult
	 * @param redirect
	 * @param model
	 * @return
	 */
	@PostMapping("/submitSsnForm")
	public String generateSSN(@Valid @ModelAttribute("ssnModelAttribute") SsnEnrollmentModel ssnEnrollModel,
			BindingResult errorResult, RedirectAttributes redirect, Model model) {

		/**
		 * Validating server side errors..
		 */
		if (errorResult.hasErrors()) {
			model.addAttribute(new SsnEnrollmentModel());
			initialization(model);

			return AppConstantsUtils.SSN_REGISTRATION_VIEW;
		}
		LOG.debug("Generate ssn method is started..");
		if (ssnEnrollModel != null) {
			String generatedSsn = ssnService.generateSsn(ssnEnrollModel);
			if (generatedSsn != null) {
				redirect.addFlashAttribute(AppConstantsUtils.GENERATED_SSN, generatedSsn);
				LOG.debug("Generate ssn method is ended..");
				LOG.info("Generate ssn method is executed successfully..");
			} else {
				LOG.error("Registration failed..");
				throw new RegistrationFailed("Registration failed! Try again.");

			}
			model.addAttribute(new SsnEnrollmentModel());
			initialization(model);

		}

		return "redirect:/success";
	}

	/**
	 * This method is for avoiding double posting in ssn form submission..
	 * 
	 * @param ssnModel
	 * @param model
	 * @return
	 */
	@GetMapping("/success")
	public String ssnDoublePost(@ModelAttribute("ssnModelAttribute") SsnEnrollmentModel ssnModel, Model model) {

		model.addAttribute(new SsnEnrollmentModel());
		initialization(model);

		return AppConstantsUtils.SSN_REGISTRATION_VIEW;
	}

	/**
	 * This method is Viewing all SSN Records...
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/viewAllSsn")
	@ApiOperation("This Get method for Get all ssn registered list from Ssn_Master table")
	public String viewSsn(Model model) {

		LOG.debug("viewSsn method  method is started");
		List<SsnEnrollmentModel> ssnListModel = ssnService.getAllSsnDetails();

		if (ssnListModel != null) {
			model.addAttribute("ssnList", ssnListModel);
			LOG.debug("ViewSsn method is ended");
			LOG.info("ViewSsn method executed successfully..");
		} else {

			LOG.warn("No Data found !");
			throw new NoDataFound("No dta found");
		}

		return AppConstantsUtils.ALL_SSN_VIEW;
	}

	@GetMapping("/savestates")
	@ApiOperation("This Get method for save state in STATE_MASTER table")
	public String saveStates(Model model) {

		StateModel stateModel = new StateModel();
		stateModel.setStateId(1);
		stateModel.setStateName("Alabama");
		stateModel.setStateCode("AL");

		ssnService.saveState(stateModel);
		/**
		 * Reading msg form yml using AppConfig cls..
		 * 
		 */
		String msg = appConfig.getProperties().get(AppConstantsUtils.SUCCESS_MESSAGE);
		model.addAttribute(AppConstantsUtils.SUCCESS_MESSAGE_KEY, msg);

		return AppConstantsUtils.SAVE_STATES_VIEW;
	}

	/**
	 * This method is for geting Gender list and states..
	 * 
	 * @param model
	 */
	public void initialization(Model model) {

		final List<String> stateList = ssnService.getAllStates();
		if (stateList != null) {
			LOG.info("stateList :" + stateList);
			model.addAttribute(AppConstantsUtils.GET_STATES_LIST, stateList);
		} else
			LOG.warn("No State found in db..");

		List<String> gender = new ArrayList<>();
		gender.add("Male");
		gender.add("Female");

		model.addAttribute(AppConstantsUtils.GET_GENDER, gender);

	}

}
