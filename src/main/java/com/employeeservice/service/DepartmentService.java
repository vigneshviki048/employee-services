package com.employeeservice.service;

import java.util.List;

import com.employeeservice.entity.Department;
import com.employeeservice.exception.GenericCustomException;

public interface DepartmentService {

	List<Department> findAllDepartment() throws GenericCustomException;
	
	Department findByDepartmentId(Long departmentid) throws GenericCustomException;
	
	Department save(Department department) throws GenericCustomException;
	
	Department update(Department department) throws GenericCustomException;
	
	void delete(Long departmentid) throws GenericCustomException;
}
