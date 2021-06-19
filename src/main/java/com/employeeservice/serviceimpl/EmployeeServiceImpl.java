package com.employeeservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.employeeservice.entity.Employee;
import com.employeeservice.exception.GenericCustomException;
import com.employeeservice.exception.RecordNotFoundException;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.service.EmployeeService;
import com.sun.media.jfxmedia.logging.Logger;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAllEmployee() throws GenericCustomException{
		
		log.info("Inside findAllEmployee");
		List<Employee> employeeList=employeeRepository.findAll();
		if(CollectionUtils.isEmpty(employeeList)) {
			log.debug("employeeList is empty so throws record not found");
			throw new RecordNotFoundException();
		}
		
		return employeeList;
	}

	@Override
	public Employee findByEmployeeId(Long employeeid) throws GenericCustomException{
		log.info("Inside findByEmployeeId");
		Employee employee=employeeRepository.findByEmployeeid(employeeid);
		if(null == employee) {
			log.debug("employee is null so throws record not found");
			throw new RecordNotFoundException();
		}
		
		return employee;
	}

	@Override
	public Employee save(Employee employee) throws GenericCustomException{
		log.info("Inside save");
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) throws GenericCustomException{
		log.info("Inside update");
		Employee updateEmployee = employeeRepository.findByEmployeeid(employee.getEmployeeid());
		updateEmployee.setName(employee.getName());
		updateEmployee.setAddress(employee.getAddress());
		updateEmployee.setDob(employee.getDob());
		updateEmployee.setPan(employee.getPan());
		updateEmployee.setDepartmentid(employee.getDepartmentid());
        return employeeRepository.save(employee);
	}

	@Override
	public void delete(Long employeeid) throws GenericCustomException{
		log.info("Inside delete");
		employeeRepository.deleteById(employeeid);
	}

}
