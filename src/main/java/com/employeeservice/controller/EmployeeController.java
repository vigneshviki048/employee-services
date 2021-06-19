package com.employeeservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.constants.EmployeeApiConstants;
import com.employeeservice.entity.Employee;
import com.employeeservice.exception.GenericCustomException;
import com.employeeservice.responses.EmployeeApiResponse;
import com.employeeservice.responses.FetchEmployeeApiResponse;
import com.employeeservice.responses.FetchEmployeeListApiResponse;
import com.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value="/employee",produces = "application/json")
	public FetchEmployeeListApiResponse getEmployeeDetails() {

		try {
			List<Employee> employeeList=employeeService.findAllEmployee();
			if(CollectionUtils.isEmpty(employeeList))
				throw new GenericCustomException("employeeList response is empty",HttpStatus.PRECONDITION_FAILED);
			else
				return FetchEmployeeListApiResponse.builder()
						.statusCode(EmployeeApiConstants.SuccessCode)
						.message(EmployeeApiConstants.SuccessMessage)
						.employee(employeeList).build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="/employee/{employeeid}",produces = "application/json")
	public FetchEmployeeApiResponse getEmployee(@PathVariable Long employeeid) {
		try {
			Employee employee=employeeService.findByEmployeeId(employeeid);

			return FetchEmployeeApiResponse.builder()
					.statusCode(EmployeeApiConstants.SuccessCode)
					.message(EmployeeApiConstants.SuccessMessage)
					.employee(employee).build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value="/employee",produces = "application/json")
	public EmployeeApiResponse createEmployee(@Valid @RequestBody Employee employee) {

		try {
			Employee createResponse= employeeService.save(employee);
			if(null==createResponse) 
				throw new GenericCustomException("Create response is empty",HttpStatus.PRECONDITION_FAILED);
			else
				return EmployeeApiResponse.builder()
						.statusCode(EmployeeApiConstants.SuccessCode)
						.message(EmployeeApiConstants.CreateMessage)
						.build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/employee",produces = "application/json")
	public EmployeeApiResponse updateEmployee(@Valid @RequestBody Employee employee) {
		try {
			Employee updateResponse= employeeService.update(employee);
			if(null==updateResponse) 
				throw new GenericCustomException("Update response is empty",HttpStatus.PRECONDITION_FAILED);
			else
				return EmployeeApiResponse.builder()
						.statusCode(EmployeeApiConstants.SuccessCode)
						.message(EmployeeApiConstants.UpdateMessage)
						.build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value="/employee/{employeeid}",produces = "application/json")
	public EmployeeApiResponse delete(@PathVariable Long employeeid) {
		try {
			employeeService.delete(employeeid);
			return EmployeeApiResponse.builder()
					.statusCode(EmployeeApiConstants.SuccessCode)
					.message(EmployeeApiConstants.DeleteMessage)
					.build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
