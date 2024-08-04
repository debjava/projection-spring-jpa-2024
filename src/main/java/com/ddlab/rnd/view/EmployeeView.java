package com.ddlab.rnd.view;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeView {
	
	@Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
