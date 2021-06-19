package com.employeeservice.responses;

import com.employeeservice.entity.Department;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FetchDepartmentApiResponse {
	private Integer statusCode;
	private String message;
	private Department department;
}