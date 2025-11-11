package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.IEmployeeController;
import com.alihaydar.dto.DtoEmployee;
import com.alihaydar.services.IEmployeeServices;


@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements IEmployeeController{

	
	@Autowired
	private IEmployeeServices employeeServices;
	
	@Override
	@GetMapping("/{id}")
	public DtoEmployee findEmployeeById(@PathVariable("id") Long id) {
		
		System.out.println("KONTROL ID : " + id );
		return employeeServices.findEmployeeById(id);
	}

}
