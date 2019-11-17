package com.momenton.exceptions;

public class NoManagerException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoManagerException(Integer empId)
    {
        super("The manager assigned is invalid for employee - " + empId);
    }
}
