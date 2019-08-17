package com.jeni.exceptions;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID =1L;
	
	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(Throwable message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
