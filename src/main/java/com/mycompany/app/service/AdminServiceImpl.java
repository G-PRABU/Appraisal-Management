package com.mycompany.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.Employee;
import com.mycompany.app.repository.EmployeeRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public boolean saveEmployee(Employee e) {
		try {
			employeeRepository.save(e);
			return true;
		} catch(Exception ex) {
		    return false;
		}
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.getOne(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
