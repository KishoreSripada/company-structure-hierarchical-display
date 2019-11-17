package com.momenton;

import com.momenton.beans.Employee;
import com.momenton.beans.Company;
import com.momenton.exceptions.EmployeeDataException;
import com.momenton.exceptions.NoManagerException;

public class OrganisationStructureMain {

    public static void main(String[] args) {
        Company company = new Company();
        try {
            company.addEmployee(new Employee(150, null, "Jamie", true));
        } catch (EmployeeDataException | NoManagerException e) {
            e.printStackTrace();
        }
    }
}