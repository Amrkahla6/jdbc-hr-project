package com.globle.hr.repository;

import java.util.List;

import com.globle.hr.entity.Employee;

public interface EmployeeRepos {
	
	int count();
	
	Employee FindById(Long id);
	
	List<Employee> findAll();
	
	int insert(Employee employee);
	
	int update(Employee employee);
	
	int delete(Long id);
}
