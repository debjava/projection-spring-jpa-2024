package com.ddlab.rnd.repository;

import com.ddlab.rnd.entity.Emp;
import com.ddlab.rnd.view.EmployeeView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificEmpRepo extends org.springframework.data.repository.Repository<Emp, Long> {
    @Query("select e from Emp e")
    List<EmployeeView> fetchAllEmps();
}
