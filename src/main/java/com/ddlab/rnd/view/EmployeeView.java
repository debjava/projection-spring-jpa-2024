package com.ddlab.rnd.view;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeView {
	@Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
    @Value("#{target.location}")
    String getLocation();
    @Value("#{target.maritalStatus}")
    String getMaritalStatus();
}
