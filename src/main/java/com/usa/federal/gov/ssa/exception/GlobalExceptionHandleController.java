package com.usa.federal.gov.ssa.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usa.federal.gov.ssa.util.AppConstantsUtils;

@Controller
@ControllerAdvice
public class GlobalExceptionHandleController {

	@ExceptionHandler(value = RegistrationFailed.class)
	public String regFailedHandle(Model model) {

		model.addAttribute(AppConstantsUtils.REG_FAILED_KEY, AppConstantsUtils.REG_FAILED_MSG);
		return AppConstantsUtils.ERRORS_VIEW;
	}
	
	@ExceptionHandler(value=NoStateFoundList.class)
	public String noStateFoundHandle(Model model) {
		
		 model.addAttribute(AppConstantsUtils.NO_STATE_FOUND,AppConstantsUtils.NO_STATE_FOUND_MSG);
		
		    return AppConstantsUtils.ERRORS_VIEW;
	}
	@ExceptionHandler(value=NoDataFound.class)
	public String noDataFound(Model model) {
		model.addAttribute("noDataFound","Thesre is no data in db");
		
		return AppConstantsUtils.ERRORS_VIEW;
	}
}
