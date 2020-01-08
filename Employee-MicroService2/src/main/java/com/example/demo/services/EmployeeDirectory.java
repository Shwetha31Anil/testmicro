package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.beans.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repos.EmployeeRespository;

@Service
@EnableTransactionManagement
public class EmployeeDirectory implements Directory {

	@Autowired
	EmployeeRespository employeeRespository;
	
	@Transactional
	public void add(Employee employee) {
		employeeRespository.save(employee);
	}
	
	public Employee find(int id) {
		return employeeRespository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException());
	}
	
}
