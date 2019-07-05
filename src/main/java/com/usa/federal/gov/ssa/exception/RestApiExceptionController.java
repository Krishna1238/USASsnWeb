package com.usa.federal.gov.ssa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller is for handling Global Custom exception 
 * @author Krishna Murari
 *
 */
@RestController
@ControllerAdvice
public class RestApiExceptionController {
      
	 @ExceptionHandler(value=NoStateFound.class)
	public ResponseEntity<AppError> handeleApiException() {
		      
		       AppError error=new AppError(400,"There no ssn and state with this ssn Id",new Date());
		
		       return new ResponseEntity<AppError> (error,HttpStatus.BAD_REQUEST);
	}
}
