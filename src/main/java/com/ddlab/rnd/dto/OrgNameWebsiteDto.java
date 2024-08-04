package com.ddlab.rnd.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrgNameWebsiteDto {

	private String name;

	private String website;

	public OrgNameWebsiteDto(String name, String website) {
		super();
		this.name = name;
		this.website = website;
	}
}
