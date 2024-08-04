package com.ddlab.rnd.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Branch") @Table(name = "branch")
@Getter @Setter @ToString(exclude="employees") @NoArgsConstructor
public class Branch {
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	private String location;
	
	private String branchCode;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();

	public Branch(String name, String location, String branchCode) {
		super();
		this.name = name;
		this.location = location;
		this.branchCode = branchCode;
	}

}
