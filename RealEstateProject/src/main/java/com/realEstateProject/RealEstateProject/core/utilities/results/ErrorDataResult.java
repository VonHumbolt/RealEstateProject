package com.realEstateProject.RealEstateProject.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(false, data, message);
	
	}
	
	public ErrorDataResult(T data) {
		super(false, data);
	}
	
	public ErrorDataResult(String message) {
		super(false, message);
	}
	
	public ErrorDataResult() {
		super(false);
	}

}
