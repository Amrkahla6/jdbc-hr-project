package com.globle.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globle.hr.entity.Employee;
import com.globle.hr.repository.EmployeeRepos;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepos employeeRepos;
	
	@GetMapping("/count")
	public int countEmployee() {
		return employeeRepos.count();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepos.FindById(id);
	}
	
	@GetMapping("")
	public List<Employee> findAll(){
		return employeeRepos.findAll();
	}
}
