package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.services.Directory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("Endpoint for employee operations like add, getby id and delete")
public class EmployeeController {

	@Autowired
	Directory directory;
	
	//@RequestMapping(value="/employee",method = RequestMethod.GET)
	@PostMapping("/employee")
	@ApiOperation("post a new employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		directory.add(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/{id}")
	@ApiOperation("fetch employee by path variable id or return 404")
	public ResponseEntity<Employee> getEMployeeById(@PathVariable("id")int id){
		try {
			Employee employee=directory.find(id);
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}catch(EmployeeNotFoundException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
