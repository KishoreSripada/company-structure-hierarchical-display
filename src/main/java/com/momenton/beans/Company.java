package com.momenton.beans;

import java.util.ArrayList;
import java.util.List;
import com.momenton.beans.Employee;

public class Company {

	private List<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	public List<Employee> getEmployeesList() {
		return employees;
	}
}
