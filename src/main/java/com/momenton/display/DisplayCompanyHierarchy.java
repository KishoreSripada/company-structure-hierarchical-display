package com.momenton.display;

import java.util.List;
import java.util.stream.Collectors;

import com.momenton.beans.Company;
import com.momenton.beans.Employee;

public class DisplayCompanyHierarchy {
    
    private List<Employee> employees = null;

	public void displayCompanyHierarchy(Company company) {
		employees = company.getEmployeesList();
        System.out.println("Company Hierarchy");
        
        Employee ceo = employees.stream().filter(e -> e.isCEO()).findAny().get();
        displayHierarchy(ceo, 0);
    }

    public void displayHierarchy(Employee emp, int depth) {
        System.out.println(computeSpacesToBePrintedBeforeTheName(depth) + emp.getName());
        if (!find_All_Reporting_Employees_For_Manager(emp, employees).isEmpty()) {
            for (Employee subordinate : find_All_Reporting_Employees_For_Manager(emp, employees)) {
                displayHierarchy(subordinate, depth + 1);
            }
        }
    }
    
	public List<Employee> find_All_Reporting_Employees_For_Manager(Employee emp, List<Employee> employees) {
		return employees.stream().filter((e) -> {
			if (e.getManagerId() == null) return false;
			return e.getManagerId().equals(emp.getId());
		}).collect(Collectors.toList());
    }
    
	private String computeSpacesToBePrintedBeforeTheName(int depth) {
		if (depth == 0) return "";
		StringBuilder separator = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			separator.append("\t");
		}
		return separator.toString();
	}
}