package com.ddlab.rnd.repository;


import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.view.EmployeeView;

@Repository
public interface EmployeeRepository extends org.springframework.data.repository.Repository<Employee, Long> {
	
	// Do not use findById, it will throw exception, as it will return Employee object
	EmployeeView findEmpById(Long id);
}
