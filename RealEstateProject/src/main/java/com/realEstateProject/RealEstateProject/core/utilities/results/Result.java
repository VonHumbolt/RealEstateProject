package com.realEstateProject.RealEstateProject.core.utilities.results;

public class Result {
	
	private String message;
	
	private boolean success;
	
	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public boolean getSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
 }

