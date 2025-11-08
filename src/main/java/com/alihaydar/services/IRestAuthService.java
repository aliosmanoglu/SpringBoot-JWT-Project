package com.alihaydar.services;

import com.alihaydar.dto.DtoUser;
import com.alihaydar.jwt.AuthRequest;
import com.alihaydar.jwt.AuthResponse;

public interface IRestAuthService {

	public DtoUser register(AuthRequest register);
	
	
	public AuthResponse authenticate(AuthRequest request);
	
}
