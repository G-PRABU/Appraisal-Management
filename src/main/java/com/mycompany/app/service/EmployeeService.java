package com.mycompany.app.service;

import java.util.List;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Goal;

public interface EmployeeService {

	List<Goal> getAllGoals();
	
	Employee getEmployee(String username);

	Goal getGoal(Long id);

	void assignGoal(Employee employee, Goal goal, int goalDuration);

	void completeGoal(long id);

	List<AssignedGoal> getAllAssignedGoal(Employee employee);

	List<Goal> search(String keyword);

}
