package com.alihaydar.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alihaydar.dto.DtoDepartment;
import com.alihaydar.dto.DtoEmployee;
import com.alihaydar.model.Department;
import com.alihaydar.model.Employee;
import com.alihaydar.repository.EmployeeRepository;
import com.alihaydar.services.IEmployeeServices;


@Service
public class EmployeeServiceImpl implements IEmployeeServices{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		DtoEmployee dtoEmployee = new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();
		
		Optional<Employee> optional =  employeeRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Employee employee = optional.get();
		Department department = employee.getDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDepartment(dtoDepartment);
		
		
		return dtoEmployee;
	}

}
