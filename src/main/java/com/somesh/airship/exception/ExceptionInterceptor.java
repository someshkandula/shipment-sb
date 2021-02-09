package com.somesh.airship.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.somesh.airship.dto.ErrorDetails;

/**
 * @author ksomalin
 *
 */
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionInterceptor.class);

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationExceptions(ConstraintViolationException ex) {
		LOGGER.error("ConstraintViolationException ex {} ", ex.getMessage(), ex);
		ErrorDetails errorDetails = new ErrorDetails(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				"Invalid input parameters : " + ex.getMessage().toString());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error("MethodArgumentNotValidException {} {}", ex.getMessage(), HttpStatus.BAD_REQUEST, ex);
		ErrorDetails errorDetails = new ErrorDetails(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				" Validation Failed : " + ex.getMessage().toString());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		LOGGER.error("handleAllExceptions ex {} ", ex.getMessage(), ex);
		ErrorDetails errorDetails = new ErrorDetails(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
				" Internal Server Error : " + ex.getMessage().toString() + request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}