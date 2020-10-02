package com.carriernet.assignment.exception;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author abhimanyu.kumar
 *
 */
public class CarriernetException extends RuntimeException {

	private static final long serialVersionUID = -4854969022129516751L;
	
	private final HttpStatus httpStatus;

	public CarriernetException(String msg, Throwable t,HttpStatus httpStatus) {
		super(msg, t);
		this.httpStatus=httpStatus;
	}

	public CarriernetException(String msg,HttpStatus httpStatus) {
		super(msg);
		this.httpStatus=httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
