package com.momenton;

import com.momenton.beans.Employee;
import com.momenton.display.DisplayCompanyHierarchy;
import com.momenton.beans.Company;
import com.momenton.exceptions.EmployeeDataException;
import com.momenton.exceptions.NoManagerException;

public class OrganisationStructureMain {

    public static void main(String[] args) {
        Company company = new Company();
        try {
            company.addEmployee(new Employee(150, null, "Jamie", true));
            company.addEmployee(new Employee(100, 150, "Alan", false));
            company.addEmployee(new Employee(220, 100, "Martin", false));
            company.addEmployee(new Employee(275, 100, "Alex", false));
            company.addEmployee(new Employee(400, 150, "Steve", false));
            company.addEmployee(new Employee(190, 400, "David", false));
        } catch (EmployeeDataException | NoManagerException e) {
            e.printStackTrace();
        }
        DisplayCompanyHierarchy hierarchy = new DisplayCompanyHierarchy();
        hierarchy.displayCompanyHierarchy(company);
    }
}