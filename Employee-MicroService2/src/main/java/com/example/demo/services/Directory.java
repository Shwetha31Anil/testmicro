package com.example.demo.services;

import com.example.demo.beans.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;

public interface Directory {
	public void add(Employee e);
	public Employee find(int id)throws EmployeeNotFoundException;
	

}
