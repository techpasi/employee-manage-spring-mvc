package com.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.mvc.model.Employee;


@Component
public class EmployeeDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addEmployee(Employee employee) {
		hibernateTemplate.save(employee);
	}
	
	@Transactional
	public List<Employee> getAllEmployee() {
		return hibernateTemplate.loadAll(Employee.class);
	}
	
	@Transactional
	public Employee getById(Long id) {
		return (Employee)hibernateTemplate.get(Employee.class,id);
	}
	
	@Transactional
	public void updateEmployee(Employee employee) {
		hibernateTemplate.update(employee);
	}
}
