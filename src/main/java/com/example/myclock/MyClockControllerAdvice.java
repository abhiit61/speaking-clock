package com.example.myclock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyClockControllerAdvice extends ResponseEntityExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
		logger.debug("Handled: IllegalArgumentException", ex);
		return handleExceptionInternal(ex, new ResponseEntity<>("Invalid time", HttpStatus.BAD_REQUEST), null,
				HttpStatus.BAD_REQUEST, null);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		logger.debug("Handled: MissingServletRequestParameter", ex);
		return handleExceptionInternal(ex,
				new ResponseEntity<>("Parameter " + ex.getParameterName() + " is missing", HttpStatus.BAD_REQUEST),
				headers, status, request);
	}

}
