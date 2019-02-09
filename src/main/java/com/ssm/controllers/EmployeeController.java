package com.ssm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.dao.EmployeeDAO;
import com.ssm.pojo.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO empDao;
	
	@GetMapping("/emp")
	public List<Employee> getAllEmployees() {
		return empDao.getAllEmployees();
	}
	
	@GetMapping("/emp/{empId}")
	public Employee getEmployeeById(@PathVariable Integer empId) {
		return empDao.getEmployeeById(empId);
	}
	
	@PostMapping("/emp")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		System.out.println("EmploeeId - " + emp.getId());
		empDao.saveEmployee(emp);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
