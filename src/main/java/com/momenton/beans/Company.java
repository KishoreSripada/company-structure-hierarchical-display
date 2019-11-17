package com.momenton.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.momenton.beans.Employee;
import com.momenton.exceptions.EmployeeDataException;
import com.momenton.exceptions.NoManagerException;

public class Company {

	private List<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee emp) throws EmployeeDataException, NoManagerException {
		if (isExistingEmployee(emp.getId())) {
			throw new EmployeeDataException("Duplicate Employee Record Found. Please verify");
		}
		if(!emp.isCEO() && emp.getManagerId() == null){
			throw new EmployeeDataException("All employees excluding CEO must have a manager assigned. " +  
			" Please assign a manager to employee - " + emp.getName());
		}
		Optional<Employee> manager = employees.stream().filter((e) -> emp.getManagerId().equals(e.getId())).findAny();
		if (!emp.isCEO() && !manager.isPresent()) {
			throw new NoManagerException(emp.getId());
		}
		employees.add(emp);
	}

	private boolean isExistingEmployee(Integer id) {
		Optional<Employee> emp = employees.stream().filter((e) -> e.getId().equals(id)).findAny();
		return emp.isPresent();
	}

	public List<Employee> getEmployeesList() {
		return employees;
	}
}
