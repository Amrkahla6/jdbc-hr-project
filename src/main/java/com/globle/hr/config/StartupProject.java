package com.globle.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globle.hr.entity.Employee;
import com.globle.hr.repository.EmployeeRepos;

@Component
public class StartupProject implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmployeeRepos employeeRepos;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate.execute("DROP TABLE IF EXISTS employees");
		jdbcTemplate.execute("CREATE TABLE employees(id SERIAL, name VARCHAR(255), salary NUMERIC(15,2))");

		if(employeeRepos.count() == 0) {
		    employeeRepos.insert(new Employee(20L, "Mohamed", 5221.0));
		    employeeRepos.insert(new Employee(30L, "Nour", 8569.0));
		    employeeRepos.insert(new Employee(40L, "Ali", 5521.0));
		}
	}

}
