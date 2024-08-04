package com.ddlab.rnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ddlab.rnd.entity.Employee;

@org.springframework.stereotype.Repository
public interface EmployeeDynamicRepository extends Repository<Employee, Long> {

	@Query("Select e from Employee e where e.firstName like %:firstName%")
	<T> List<T> getEmployeeAsPerNameLike(String firstName, Class<T> type);
}
