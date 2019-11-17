package com.momenton;

import com.momenton.beans.Company;
import com.momenton.beans.Employee;
import com.momenton.display.DisplayCompanyHierarchy;
import com.momenton.exceptions.EmployeeDataException;
import com.momenton.exceptions.NoManagerException;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import org.powermock.reflect.internal.WhiteboxImpl;

public class DisplayCompanyHierarchyTest {

    private DisplayCompanyHierarchy hierarchy = null;
    private Company company = null;

    @Before
    public void setUp() throws EmployeeDataException, NoManagerException {
        company = new Company();
        company.addEmployee(new Employee(150, null, "Jamie", true));
        company.addEmployee(new Employee(100, 150, "Alan", false));
        company.addEmployee(new Employee(220, 100, "Martin", false));
        company.addEmployee(new Employee(275, 100, "Alex", false));
        company.addEmployee(new Employee(400, 150, "Steve", false));
        company.addEmployee(new Employee(190, 400, "David", false));
		hierarchy = new DisplayCompanyHierarchy();
    }
    
    @Test
    public void should_return_hierarchy_based_on_manager_employee_combination() {
        hierarchy.displayCompanyHierarchy(company);
        assertThat(company.getEmployeesList().size(), is(6));
    }

	@Test
	public void should_return_direct_reportees()
	{ 
        Employee ceo = company.getEmployeesList().stream().filter(emp -> emp.isCEO()).findAny().get();
		List<Employee> reportees = hierarchy.find_All_Reporting_Employees_For_Manager(ceo, company.getEmployeesList());
		assertThat(reportees.size(), is(2));
		assertThat(reportees.get(0).getId(),is(100));
        assertThat(reportees.get(1).getId(),is(400));
	}

	@Test
	public void should_return_correct_spaces_for_steve() throws Exception {

		String result = WhiteboxImpl.invokeMethod(hierarchy,"computeSpacesToBePrintedBeforeTheName",3);
		assertThat(result.length(),is(3));
	}
	@Test
	public void should_return_correct_spaces_for_ceo() throws Exception {

		String result = WhiteboxImpl.invokeMethod(hierarchy,"computeSpacesToBePrintedBeforeTheName",0);
		assertThat(result.length(),is(0));
	}
    @Test
    public void should_return_correct_spaces_for_alan() throws Exception {

        String result = WhiteboxImpl.invokeMethod(hierarchy,"computeSpacesToBePrintedBeforeTheName",1);
        assertThat(result.length(),is(1));
    }
    @Test
    public void should_return_correct_spaces_for_martin() throws Exception {

        String result = WhiteboxImpl.invokeMethod(hierarchy,"computeSpacesToBePrintedBeforeTheName",2);
        assertThat(result.length(),is(2));
    }
}