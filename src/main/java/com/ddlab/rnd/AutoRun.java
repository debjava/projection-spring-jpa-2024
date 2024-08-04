package com.ddlab.rnd;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.dto.OrgNameWebsiteDto;
import com.ddlab.rnd.entity.Branch;
import com.ddlab.rnd.entity.Department;
import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.entity.Organisation;
import com.ddlab.rnd.repository.BranchRepository;
import com.ddlab.rnd.repository.EmployeeDynamicRepository;
import com.ddlab.rnd.repository.EmployeeRepository;
import com.ddlab.rnd.repository.OrgRepository;
import com.ddlab.rnd.view.BranchRecord;
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
		showEmpDynamicView();
		
	}

}
