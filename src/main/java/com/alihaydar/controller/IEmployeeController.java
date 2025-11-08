package com.alihaydar.controller;

import com.alihaydar.dto.DtoEmployee;

public interface IEmployeeController {

	DtoEmployee findEmployeeById(Long id);
	
	
	
}
