package com.pala.cleevio.demo.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorDetail customErrorDetail = new CustomErrorDetail(OffsetDateTime.now(), "Bad request", ex.getMessage());
		return new ResponseEntity<>(customErrorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WatchAlreadyExistsException.class)
	public final ResponseEntity<Object> handleWatchAlreadyExistsException(WatchAlreadyExistsException ex, WebRequest request) {
		CustomErrorDetail customErrorDetail = new CustomErrorDetail(OffsetDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(customErrorDetail, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(WatchNotFoundException.class)
	public final ResponseEntity<Object> handleWatchAlreadyExistsException(WatchNotFoundException ex, WebRequest request) {
		CustomErrorDetail customErrorDetail = new CustomErrorDetail(OffsetDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(customErrorDetail, HttpStatus.NOT_FOUND);
	}
	
}
