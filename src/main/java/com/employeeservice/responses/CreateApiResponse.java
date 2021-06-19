package com.employeeservice.responses;

import java.util.List;

import com.employeeservice.entity.Employee;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateApiResponse {
	private Integer statusCode;
	private String message;
	private List<Employee> employee;
}
