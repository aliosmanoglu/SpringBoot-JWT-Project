package com.alihaydar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alihaydar.dto.DtoEmployee;
import com.alihaydar.dto.DtoUser;
import com.alihaydar.model.Employee;
import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findById(Long id);
	
}
