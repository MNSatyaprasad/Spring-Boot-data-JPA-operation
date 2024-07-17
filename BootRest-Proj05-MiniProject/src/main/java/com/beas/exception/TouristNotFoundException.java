package com.beas.exception;

import org.springframework.stereotype.Component;

@Component
public class TouristNotFoundException extends RuntimeException {
	
	
	public TouristNotFoundException() {

	}
	public TouristNotFoundException(String msg) {
		super(msg);
	}

}
