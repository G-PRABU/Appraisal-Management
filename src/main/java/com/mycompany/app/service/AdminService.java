package com.mycompany.app.service;

import java.util.Collection;

import com.mycompany.app.model.Employee;

public interface AdminService {
    
	public boolean saveEmployee(Employee e);
	public Employee getEmployee(Long id);
	public Collection<Employee> getAllEmployees();
}
