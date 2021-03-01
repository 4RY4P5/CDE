package com.cognizant.springlearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Country Not Found") 
public class CountryNotFoundException extends RuntimeException {

	private String id;

	public CountryNotFoundException(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
