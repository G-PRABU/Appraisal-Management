package com.mycompany.app.service;

import java.util.Collection;
import java.util.List;

import com.mycompany.app.model.Employee;
import com.mycompany.app.model.GoalRating;
import com.mycompany.app.model.Manager;

public interface ManagerService {
	
	
	public Manager getManager(Long id);
	public Manager getManager(String email);
	public Collection<Manager> getAllManagers();
	public Employee getEmployee(Long id);
	public List<Employee> searchEmployees(String keyword);
	List<Employee> getAllEmployees(Manager manager);
	boolean saveRating(GoalRating goalRating, long id);

     
}
