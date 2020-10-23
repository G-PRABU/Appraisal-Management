package com.mycompany.app.service;

import java.util.Collection;
import java.util.List;

import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Goal;
import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;

public interface HRService {

	public Collection<Goal> getAllGoals();

	boolean saveGoal(Goal g);

	Goal getGoal(Long id);

	void deleteGoal(Goal g);

	void updateGoal(Goal g);

	HR getHr(String username);

	Employee getEmployee(long id);

	List<Employee> getAllEmployees(Manager manager);

	Manager getManager(long id);

	List<Manager> getAllManagers(HR hr);

	List<Employee> searchEmployee(String keyword);

	List<Manager> searchManager(String keyword);
}
