package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.IRestAuthController;
import com.alihaydar.dto.DtoUser;
import com.alihaydar.jwt.AuthRequest;
import com.alihaydar.jwt.AuthResponse;
import com.alihaydar.services.impl.RestAuthServiceImpl;

@RestController
public class RestAuthControllerImpl implements IRestAuthController{

	@Autowired
	private RestAuthServiceImpl authServiceImpl;
	
	@Override
	@PostMapping("/register")
	public DtoUser register( @RequestBody AuthRequest request) {
		return authServiceImpl.register(request);
	}
	
	
	@Override
	@PostMapping("/authenticate")
	public AuthResponse authenticate(@RequestBody AuthRequest request) {
		
		System.out.println("get kontrol");
		return authServiceImpl.authenticate(request);
	}

	
	
	
}
