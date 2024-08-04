package com.ddlab.rnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Employee") @Table(name = "employee")
@Getter @Setter @ToString @NoArgsConstructor
public class Employee {

	@Id @GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private int sal;

	public Employee(String firstName, String lastName, int age, int sal) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sal = sal;
	}
	
}
