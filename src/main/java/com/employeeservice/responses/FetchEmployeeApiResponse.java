package com.employeeservice.responses;

import com.employeeservice.entity.Employee;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FetchEmployeeApiResponse {
	private Integer statusCode;
	private String message;
	private Employee employee;
}