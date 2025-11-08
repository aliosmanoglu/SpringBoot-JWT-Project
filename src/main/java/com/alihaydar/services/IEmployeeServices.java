package com.alihaydar.services;

import com.alihaydar.dto.DtoEmployee;

public interface IEmployeeServices {

	
	DtoEmployee findEmployeeById(Long id);
}
