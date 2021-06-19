package com.employeeservice.responses;

import java.util.List;

import com.employeeservice.entity.Department;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FetchDepartmentListApiResponse {
	private Integer statusCode;
	private String message;
	private List<Department> department;
}