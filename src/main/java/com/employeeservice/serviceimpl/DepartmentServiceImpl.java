package com.employeeservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.employeeservice.entity.Department;
import com.employeeservice.exception.GenericCustomException;
import com.employeeservice.exception.RecordNotFoundException;
import com.employeeservice.repository.DepartmentRepository;
import com.employeeservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> findAllDepartment() throws GenericCustomException{
		log.info("Inside findAllDepartment");

		List<Department> departmentList=departmentRepository.findAll();
		if(CollectionUtils.isEmpty(departmentList))
			throw new RecordNotFoundException();

		return departmentList;
	}

	@Override
	public Department findByDepartmentId(Long departmentid) throws GenericCustomException {
		log.info("Inside findByDepartmentId");
		Department department= departmentRepository.findByDepartmentid(departmentid);
		if(null==department) {
			log.debug("Department is null so throwing Record Not Found");
			throw new RecordNotFoundException();
		}

		return department;
	}

	@Override
	public Department save(Department department) throws GenericCustomException{
		log.info("Inside save");
		return departmentRepository.save(department);
	}

	@Override
	public Department update(Department department) throws GenericCustomException{
		log.info("Inside update");
		Department updateDepartment = departmentRepository.findByDepartmentid(department.getDepartmentid());
		updateDepartment.setDepartmentname(department.getDepartmentname());
		updateDepartment.setDepartmenthead(department.getDepartmenthead());
		return departmentRepository.save(updateDepartment);
	}

	@Override
	public void delete(Long departmentid) throws GenericCustomException{
		log.info("Inside delete");
		departmentRepository.deleteById(departmentid);
	}

}
