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
import com.employeeservice.entity.Department;
import com.employeeservice.exception.GenericCustomException;
import com.employeeservice.responses.EmployeeApiResponse;
import com.employeeservice.responses.FetchDepartmentApiResponse;
import com.employeeservice.responses.FetchDepartmentListApiResponse;
import com.employeeservice.service.DepartmentService;

@RestController
@RequestMapping("/employee-service")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(value="/department",produces = "application/json")
	public FetchDepartmentListApiResponse getDepartmentDetails() {

		try {
			List<Department> departmentList= departmentService.findAllDepartment();

			return FetchDepartmentListApiResponse.builder()
					.statusCode(EmployeeApiConstants.SuccessCode)
					.message(EmployeeApiConstants.SuccessMessage)
					.department(departmentList).build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value="/department/{departmentid}",produces = "application/json")
	public FetchDepartmentApiResponse getDepartment(@PathVariable Long departmentid) {

		try {
			Department department= departmentService.findByDepartmentId(departmentid);

			return FetchDepartmentApiResponse.builder()
					.statusCode(EmployeeApiConstants.SuccessCode)
					.message(EmployeeApiConstants.SuccessMessage)
					.department(department).build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value="/department",produces = "application/json")
	public EmployeeApiResponse createDepartment(@Valid @RequestBody Department department) {
		try {
			Department createResponse= departmentService.save(department);
			if(null == createResponse)
				throw new GenericCustomException("create response is empty",HttpStatus.PRECONDITION_FAILED);
			else
				return EmployeeApiResponse.builder()
						.statusCode(EmployeeApiConstants.SuccessCode)
						.message(EmployeeApiConstants.CreateMessage)
						.build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/department",produces = "application/json")
	public EmployeeApiResponse updateDepartment(@Valid @RequestBody Department department) {
		try {
			Department updateResponse= departmentService.update(department);
			if(null == updateResponse)
				throw new GenericCustomException("update response is empty",HttpStatus.PRECONDITION_FAILED);
			else
				return EmployeeApiResponse.builder()
						.statusCode(EmployeeApiConstants.SuccessCode)
						.message(EmployeeApiConstants.UpdateMessage)
						.build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value="/department/{departmentid}",produces = "application/json")
	public EmployeeApiResponse deleteDepartment(@PathVariable Long departmentid) {
		try {
			departmentService.delete(departmentid);
			return EmployeeApiResponse.builder()
					.statusCode(EmployeeApiConstants.SuccessCode)
					.message(EmployeeApiConstants.DeleteMessage)
					.build();
		}catch(Exception e) {
			throw new GenericCustomException("Something Happened",e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
