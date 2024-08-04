package com.ddlab.rnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.dto.OrgNameWebsiteDto;
import com.ddlab.rnd.entity.Organisation;
import com.ddlab.rnd.view.OrgSummaryView;

@Repository
public interface OrgRepository extends CrudRepository<Organisation, Long> {

	@Query("SELECT org.name, org.website FROM Organisation org")
	List<Object[]> getNameAndWebsite();

	@Query("SELECT new com.ddlab.rnd.dto.OrgNameWebsiteDto(org.name, org.website) from Organisation org where org.name=:name")
	OrgNameWebsiteDto getNameAndWebsiteByDTO(String name);

//	@Query("SELECT org FROM Organisation org join fetch org.departments where org.name=:name")
	@Query("SELECT org FROM Organisation org where org.name=:name")
	OrgSummaryView getOrgSummary(String name);
	
	// Without using @Query
	OrgSummaryView findByCeoName(String name);
}
