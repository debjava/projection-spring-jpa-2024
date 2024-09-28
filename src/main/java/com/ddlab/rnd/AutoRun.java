package com.ddlab.rnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.dto.EmpFirstLastNameDTO;
import com.ddlab.rnd.dto.OrgNameWebsiteDto;
import com.ddlab.rnd.entity.Branch;
import com.ddlab.rnd.entity.Department;
import com.ddlab.rnd.entity.Emp;
import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.entity.Organisation;
import com.ddlab.rnd.repository.BranchRepository;
import com.ddlab.rnd.repository.EmpRepo;
import com.ddlab.rnd.repository.EmployeeDynamicRepository;
import com.ddlab.rnd.repository.EmployeeRepository;
import com.ddlab.rnd.repository.OrgRepository;
import com.ddlab.rnd.repository.SpecificEmpRepo;
import com.ddlab.rnd.view.BranchRecord;
import com.ddlab.rnd.view.EmpFinancialView;
import com.ddlab.rnd.view.EmpRecord;
import com.ddlab.rnd.view.EmpView;
import com.ddlab.rnd.view.EmployeeNameSalaryView;
import com.ddlab.rnd.view.EmployeeView;
import com.ddlab.rnd.view.OrgSummaryView;

@Component
public class AutoRun {

	@Autowired
	private OrgRepository orgRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private BranchRepository branchRepo;
	
	@Autowired
	private EmployeeDynamicRepository empDynamicRepo;

	@Autowired
	private EmpRepo empRepository;

	public void saveOrgDetails() {
		Organisation org = new Organisation("Microsoft", "www.website1.com", "Satya Nadel");

		Set<Employee> empList1 = Set.of(new Employee("John", "Abraham", 23, 3000), new Employee("Vidya", "Panda", 27, 5000),
				new Employee("Rambha", "Mishra", 29, 7000));
		Branch branch1 = new Branch("Delhi Branch", "Delhi", "002F");
		branch1.setEmployees(empList1);
		Set<Employee> empList2 = Set.of(new Employee("Urbasi","Tripathy", 31, 1700), 
				new Employee("Meneka", "Naik", 33, 9000),
				new Employee("Ramesh", "Nag", 37, 11000));
		Branch branch2 = new Branch("Bangalore Branch", "Bangalore", "007A");
		branch2.setEmployees(empList2);

		Set<Branch> branches = Set.of(branch1, branch2);
		Set<Department> departements = Set.of(new Department("Finance"), new Department("IT"));

		org.setBranches(branches);
		org.setDepartments(departements);

		orgRepo.save(org);

	}

	public void showOrgDetails() {
		List<Object[]> objectList = orgRepo.getNameAndWebsite();
		objectList.forEach(object -> {
			System.out.println("Name: " + object[0]);
			System.out.println("Website: " + object[1]);
		});
	}

	public void showOrgDetailsByDTO() {
		OrgNameWebsiteDto dto = orgRepo.getNameAndWebsiteByDTO("Microsoft");
		System.out.println("Name: " + dto.getName());
		System.out.println("Website: " + dto.getWebsite());
	}
	
	public void showOrgDetailsByOrgSummaryView() {
		OrgSummaryView orgSummaryView = orgRepo.getOrgSummary("Microsoft");
		System.out.println("Name: " + orgSummaryView.getName());
		System.out.println("Website: " + orgSummaryView.getWebsite());
		System.out.println("CEO Name: " + orgSummaryView.getCeoName());
		orgSummaryView.getDepartments().forEach( department -> {
			System.out.println("Department Name: "+department.getName());
		});
	}
	
	public void showOrgDetailsByCeoName() {
		OrgSummaryView orgSummaryView = orgRepo.findByCeoName("Satya Nadel");
		System.out.println("Name: " + orgSummaryView.getName());
		System.out.println("Website: " + orgSummaryView.getWebsite());
		System.out.println("CEO Name: " + orgSummaryView.getCeoName());
		orgSummaryView.getDepartments().forEach( department -> {
			System.out.println("Department Name: "+department.getName());
		});
	}
	
	public void showEmpDetails() {
		EmployeeView empView = empRepo.findEmpById(5L);
		System.out.println("Emp Full Name: "+empView.getFullName());
	}
	
	private void showBranchDetail() {
		BranchRecord branchRecord = branchRepo.getBranchDetailByBranchCode("007A");
		System.out.println("Branch Name: "+branchRecord.name());
		System.out.println("Branch Location: "+branchRecord.location());
	}
	
	private void showEmpDynamicView() {
		List<EmployeeNameSalaryView> empNameSalViewList = empDynamicRepo.getEmployeeAsPerNameLike("Ram", EmployeeNameSalaryView.class);
		empNameSalViewList.forEach( empNameSalView -> {
			System.out.println("Employee First Name: "+empNameSalView.getFirstName());
			System.out.println("Employee Salary: "+empNameSalView.getSal());
		});
	}

	public void saveEmpDetails() {
		List<Emp> empList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Emp emp = new Emp();
			emp.setDesignation("Designation-"+i);
			emp.setGender("Gender-"+i);
			emp.setName("Name-"+i);
			emp.setFirstName("FirstName-"+i);
			emp.setLastName("LastName-"+i);
			emp.setLocation("Location-"+i);
			emp.setSalary(i);
			emp.setMaritalStatus("-");
			emp.setPanNo("AABB-"+i);

			empList.add(emp);
		}
		empRepository.saveAll(empList);
	}

	public void showFirstNameLastName() {
		List<Object[]> objList = empRepository.getEmpFirstAndLastNameLike("Hari");
		objList.forEach( obj -> {
			System.out.println("First Name: "+obj[0]);
			System.out.println("Last Name: "+obj[1]);
		});
	}

	public void showFirstNameLastNameByDTO() {
		List<EmpFirstLastNameDTO> dtoList = empRepository.getFirstAndLastNameUsingDTO("Chennai");
		dtoList.forEach( dto -> {
			System.out.println("First Name: "+dto.getFirstName());
			System.out.println("Last Name: "+dto.getLastName());
		});
	}

	public void showEmpView() {
		List<EmpView> empViewList = empRepository.getEmpView();
		empViewList.forEach( empView -> {
			System.out.println(empView.getFirstName()+", "+empView.getLastName()+", "+empView.getLocation());
		});
	}

	public void showEmpViewWithoutQuery() {
		List<EmpView> empViewList = empRepository.findByLocation("Bangalore");
		empViewList.forEach( empView -> {
			System.out.println(empView.getFirstName()+", "+empView.getLastName()+", "+empView.getLocation());
		});
	}

	@Autowired
	private SpecificEmpRepo specificEmpRepo;

	public void showSpecificEmpView() {
		List<EmployeeView> empViewList = specificEmpRepo.fetchAllEmps();
		empViewList.forEach( empView -> {
			System.out.println(empView.getFullName()+", "+empView.getMaritalStatus()+", "+empView.getLocation());
		});
	}

	public void showEmpViewByMaritalStatus() {
		List<EmployeeView> empViewList = empRepository.findByMaritalStatus("Married");
		empViewList.forEach( empView -> {
			System.out.println(empView.getFullName()+", "+empView.getMaritalStatus()+", "+empView.getLocation());
		});
	}

	public void showEmpByGender() {
		List<EmpRecord> recordList = empRepository.findByGender("Female");
		recordList.forEach( emp -> {
			System.out.println(emp.firstName()+"  "+emp.lastName());
		});
	}

	public void showEmpFinancialStatus() {
		List<EmpFinancialView> financeViewList =
				empRepository.getEmpFinancialView11("Hari", EmpFinancialView.class);
		financeViewList.forEach( emp -> {
			System.out.println(emp.getFirstName()+" "+emp.getPanNo()+" "+emp.getSalary());
		});
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("Application ProjectionSpringJPAApp running ...");
//		saveOrgDetails();
//		showOrgDetails();
//		showOrgDetailsByDTO();
//		showOrgDetailsByOrgSummaryView();
//		showOrgDetailsByCeoName();
//		showEmpDetails();
//		showBranchDetail();
//		showEmpDynamicView();

		// Doing for Emp for more clarity
//		saveEmpDetails();
//		showFirstNameLastName();
//		showFirstNameLastNameByDTO();
//		showEmpView();
//		showEmpViewWithoutQuery();
//		showSpecificEmpView();
//		showEmpViewByMaritalStatus();
//		showEmpByGender();
		showEmpFinancialStatus();
	}


}
