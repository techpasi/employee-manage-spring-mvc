package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mvc.dao.EmployeeDao;
import com.mvc.model.Employee;

@Component
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
	public Employee getEmployeeById(Long id) {
		return employeeDao.getById(id);
	}
	
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	

}
