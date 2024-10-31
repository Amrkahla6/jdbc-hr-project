package com.globle.hr.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globle.hr.entity.Employee;
import com.globle.hr.mapper.EmployeeMapper;
import com.globle.hr.repository.EmployeeRepos;

@Component
public class EmployeeJDBCRepo implements EmployeeRepos{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employees", Integer.class);
	}

	@Override
	public Employee FindById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT id,name,salary FROM employees WHERE id = ?", new Object[] {id},
				new EmployeeMapper()
		);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT id, name, salary FROM employees", new EmployeeMapper());
	}

	@Override
	public int insert(Employee employee) {
	    return jdbcTemplate.update(
	        "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)",
	        new Object[] {employee.getId(), employee.getName(), employee.getSalary()}
	    );
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE employees SET name= ?, salaray= ?",
				new Object[] {employee.getName(),employee.getSalary()}
			);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM employees WHERE id=?",
				new Object[] {id}
			);
	}

}
