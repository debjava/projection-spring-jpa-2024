package com.ddlab.rnd.view;

import java.util.List;

public interface OrgSummaryView {

	String getName();

	String getWebsite();

	String getCeoName();
	
	List<DepartmentView> getDepartments();
}
