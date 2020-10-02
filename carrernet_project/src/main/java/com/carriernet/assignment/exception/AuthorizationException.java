package com.carriernet.assignment.exception;

/**
 * 
 * @author vikash.sinha
 *
 */
public class AuthorizationException extends RuntimeException {

	private static final long serialVersionUID = -4854969022129516751L;

	public AuthorizationException(String msg, Throwable t) {
		super(msg, t);
	}

	public AuthorizationException(String msg) {
		super(msg);
	}
}
