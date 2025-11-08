package com.alihaydar.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.IEmployeeController;
import com.alihaydar.dto.DtoEmployee;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements IEmployeeController{

	
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		DtoEmployee dtoEmployee = new DtoEmployee();
		
		
		
		
		return null;
	}

}
