package com.alihaydar.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alihaydar.dto.DtoUser;
import com.alihaydar.jwt.AuthRequest;
import com.alihaydar.jwt.AuthResponse;
import com.alihaydar.jwt.JwtService;
import com.alihaydar.model.User;
import com.alihaydar.repository.UserRepository;
import com.alihaydar.services.IRestAuthService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class RestAuthServiceImpl implements IRestAuthService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public DtoUser register(AuthRequest register) {
		DtoUser dtoUser = new DtoUser();
		User user = new User();
		
		user.setUsername(register.getUsername());
		user.setPassword(passwordEncoder.encode(register.getPassword()));
		
		User savedUser = userRepository.save(user);
		
		BeanUtils.copyProperties(user, dtoUser);
		
		return dtoUser;
	}



	@Override
	public AuthResponse authenticate(AuthRequest request) {
		try {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
			
			authenticationProvider.authenticate(auth);
			
			Optional<User> optional = userRepository.findByUsername(request.getUsername());
			
			UserDetails userDetails = optional.get();
			
			String token = jwtService.generateToken(userDetails);
			
			System.out.println("SİSTEM KONTROL");
			
			return new AuthResponse(token);
			
		} catch (Exception e) {
			System.out.println("Kullanıcı adı veya şifre hatalı");
		}
		
		return null;
	}

	
}
