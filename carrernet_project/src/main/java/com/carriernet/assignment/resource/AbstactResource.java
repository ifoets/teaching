package com.carriernet.assignment.resource;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

import com.carriernet.assignment.exception.AuthorizationException;
import com.carriernet.assignment.exception.CarriernetException;

public abstract class AbstactResource {

	@ExceptionHandler(value = { HttpStatusCodeException.class })
	public ResponseEntity<String> handleEkaException(HttpStatusCodeException hce) throws JSONException {
		return new ResponseEntity<String>(new JSONObject().put("msg", hce.getMessage()).toString(),
				hce.getStatusCode());
	}

	@ExceptionHandler(value = { CarriernetException.class })
	public ResponseEntity<String> handleEkaException(CarriernetException hce) throws JSONException {
		return new ResponseEntity<String>(new JSONObject().put("msg", hce.getMessage()).toString(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { AuthorizationException.class })
	public ResponseEntity<String> handleEkaException(AuthorizationException e) throws JSONException {
		return new ResponseEntity<>(new JSONObject().put("msg", e.getMessage()).toString(), HttpStatus.FORBIDDEN);
	}

	protected <T> ResponseEntity<T> getResponse(T body, HttpStatus httpStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Cache-Control", "no-store");
		headers.set("Pragma", "no-cache");
		return new ResponseEntity<>(body, headers, httpStatus);
	}

}
