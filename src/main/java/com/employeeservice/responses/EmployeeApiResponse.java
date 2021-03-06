package com.employeeservice.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeApiResponse {
	private Integer statusCode;
	private String message;
}
