package com.example.demo.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7400060305569013109L;
	public EmployeeNotFoundException() {
		
	}
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
