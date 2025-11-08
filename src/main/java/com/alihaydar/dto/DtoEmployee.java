package com.alihaydar.dto;

import com.alihaydar.model.Department;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {


	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private DtoDepartment department;
	
	
}
