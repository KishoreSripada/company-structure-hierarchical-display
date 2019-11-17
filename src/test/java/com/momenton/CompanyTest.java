package com.momenton;

import com.momenton.beans.Company;
import com.momenton.beans.Employee;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class CompanyTest {

	private Company company = null;

	@Before
	public void setUp() {
		company = new Company();
	}

	@Test
	public void should_create_a_valid_ceo() {
		company.addEmployee(new Employee(1, null, "Jamie", true));
		assertThat(company.getEmployeesList().size(), is(1));
	}
    
    @Test
	public void should_create_a_valid_employee() {
		company.addEmployee(new Employee(2, 1, "Alan", false));
		assertThat(company.getEmployeesList().size(), is(1));
	}
}
