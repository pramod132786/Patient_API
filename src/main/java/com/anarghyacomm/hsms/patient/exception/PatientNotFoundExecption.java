package com.anarghyacomm.hsms.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
@RestControllerAdvice
public class PatientNotFoundExecption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientNotFoundExecption() {
		super();
		
	}

	public PatientNotFoundExecption(String message) {
		super(message);
	}
	@ExceptionHandler(PatientNotFoundExecption.class)
	public ResponseEntity<String> handleResourceNotFoundException(PatientNotFoundExecption ex) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
}



