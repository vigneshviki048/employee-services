package com.employeeservice.exception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(Long id) {
		super(String.format("Record with Id %d not found", id));
	}

}