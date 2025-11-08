package com.alihaydar.controller;

import com.alihaydar.dto.DtoUser;
import com.alihaydar.jwt.AuthRequest;
import com.alihaydar.jwt.AuthResponse;

public interface IRestAuthController {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authenticate(AuthRequest request);
	
	
}
