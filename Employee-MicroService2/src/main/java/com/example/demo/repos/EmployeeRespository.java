package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Address;
import com.example.demo.beans.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
	
	//@Query(value = "", nativeQuery = true)
	public List<Employee> findEmployeeByAddress(Address address);

}
