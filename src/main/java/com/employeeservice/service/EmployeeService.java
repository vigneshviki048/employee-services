package com.employeeservice.service;

import java.util.List;

import com.employeeservice.entity.Employee;
import com.employeeservice.exception.GenericCustomException;

public interface EmployeeService {

	List<Employee> findAllEmployee() throws GenericCustomException;
	
	Employee findByEmployeeId(Long employeeid) throws GenericCustomException;
	
	Employee save(Employee employee) throws GenericCustomException;
	
	Employee update(Employee employee) throws GenericCustomException;
	
	void delete(Long employeeid) throws GenericCustomException;
}
