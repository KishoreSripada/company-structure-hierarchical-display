package com.momenton.display;

import java.util.List;
import com.momenton.beans.Company;
import com.momenton.beans.Employee;

public class DisplayCompanyHierarchy {
    
    private List<Employee> employees = null;

	public void displayCompanyHierarchy(Company company) {
		employees = company.getEmployeesList();
		System.out.println("Company Hierarchy");
        for ( Employee e : employees) {
            if ( e.isCEO()) System.out.println(e.getName());
            System.out.println("\t" + e.getName());
        }
	}
}