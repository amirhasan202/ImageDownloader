package com.in28minutes.REST.webServices.restfulwebservices.exeption;

import java.time.LocalDate;

public class ErrorDetails
{
	private LocalDate timestamp;
	private String message;
	private String details;
	
	
	public ErrorDetails(LocalDate localDate, String message, String details) {
		super();
		this.timestamp = localDate;
		this.message = message;
		this.details = details;
	}
	
	
	
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
