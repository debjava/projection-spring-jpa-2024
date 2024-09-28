package com.ddlab.rnd.repository;

import com.ddlab.rnd.dto.EmpFirstLastNameDTO;
import com.ddlab.rnd.entity.Emp;
import com.ddlab.rnd.view.EmpFinancialView;
import com.ddlab.rnd.view.EmpRecord;
import com.ddlab.rnd.view.EmpView;
import com.ddlab.rnd.view.EmployeeView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends CrudRepository<Emp, Long> {
    @Query("select e.firstName, e.lastName from Emp e where e.name like %:name%")
    List<Object[]> getEmpFirstAndLastNameLike(String name);

    @Query("select new com.ddlab.rnd.dto.EmpFirstLastNameDTO(e.firstName, e.lastName) " +
            "from Emp e where e.location =:location")
    List<EmpFirstLastNameDTO> getFirstAndLastNameUsingDTO(String location);

    @Query("select e from Emp e")
    List<EmpView> getEmpView();

    // Without using Query
    List<EmpView> findByLocation(String location);

    List<EmployeeView> findByMaritalStatus(String status);

    List<EmpRecord> findByGender(String gender);

    @Query("Select e from Emp e where e.firstName like %:firstName%")
    <T> List<T> getEmpFinancialView(String firstName, Class<T> type);

    @Query("Select e from Emp e where e.firstName like %:firstName%")
    List<EmpFinancialView> getEmpFinancialView11(String firstName, Class<EmpFinancialView> type);
}
