package com.momenton;

import com.momenton.beans.Employee;
import java.util.logging.Logger;
import com.momenton.beans.Company;

public class OrganisationStructureMain {

    private static final Logger logger = Logger.getLogger(OrganisationStructureMain.class.getName());

    public static void main(String[] args) {
        Company company = new Company();
        company.addEmployee(new Employee(150, null, "Jamie", true));
    }
}