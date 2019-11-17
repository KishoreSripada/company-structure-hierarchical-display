package com.momenton.beans;

import com.momenton.exceptions.EmployeeDataException;

public class Employee {

    private Integer id;
    private Integer managerId;
    private String name;
    private boolean isCEO;

    public Integer getId() {
        return id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }

    public boolean isCEO() {
        return isCEO;
    }

    public Employee(Integer id, Integer managerId, 
    String name, boolean isCEO) throws EmployeeDataException {

        if (isCEO && managerId != null) {
			throw new EmployeeDataException("The CEO doesn't have a manager");
		}
        if (null != name && name.isEmpty()) {
            throw new EmployeeDataException("Every Employee should have a name");
        }

        this.id = id;
        this.managerId = managerId;
        this.name = name;
        this.isCEO = isCEO;
    }
}
