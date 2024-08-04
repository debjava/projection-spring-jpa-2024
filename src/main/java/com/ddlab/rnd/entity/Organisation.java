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

@Entity(name="Organisation") @Table(name = "organisation")
@Getter @Setter @ToString(exclude = {"branches", "departments"})
@NoArgsConstructor
public class Organisation {
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	private String website;
	
	private String ceoName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Branch> branches = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Department> departments = new HashSet<>();

	public Organisation(String name, String website, String ceoName) {
		super();
		this.name = name;
		this.website = website;
		this.ceoName = ceoName;
	}

}
