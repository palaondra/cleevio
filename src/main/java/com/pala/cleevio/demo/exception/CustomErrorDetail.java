package com.pala.cleevio.demo.exception;

import java.time.OffsetDateTime;

/**
 * Entity for errors mapping.
 */
public class CustomErrorDetail {
	
	private OffsetDateTime date;
	private String message;
	private String errorDetails;
	
	public CustomErrorDetail(OffsetDateTime date, String message, String errorDetails) {
		this.date = date;
		this.message = message;
		this.errorDetails = errorDetails;
	}

	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
}
