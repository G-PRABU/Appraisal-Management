package com.mycompany.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.Manager;
import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Goal;
import com.mycompany.app.repository.AssignedGoalRepository;
import com.mycompany.app.repository.EmployeeRepository;
import com.mycompany.app.repository.GoalRepository;
import com.mycompany.app.repository.ManagerRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	GoalRepository goalRepository;
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	AssignedGoalRepository assignedGoalRepository;
	
	@Override
	public List<Goal> getAllGoals() {
		return goalRepository.findAll();
	}
	@Override
	public Goal getGoal(Long id) {
		return goalRepository.getOne(id);
	}
	
	@Override
	public List<AssignedGoal> getAllAssignedGoal(Employee employee)
	{
		return assignedGoalRepository.findByEmployee(employee);
	}
	
	@Override
	public void completeGoal(long id)
	{
		AssignedGoal assignedGoal=assignedGoalRepository.getOne(id);
		assignedGoal.setGoalStatus(true);
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		assignedGoal.setEndDate(date);
		
		assignedGoalRepository.save(assignedGoal);
		
	}
	
	@Override
	public Employee getEmployee(String username)
	{
		Optional<Employee> e=empRepository.findByEmail(username);
		if(e.isPresent())
			return e.get();
		else
			return null;
	}
	
	@Override
	public void assignGoal(Employee employee,Goal goal)
	{
		AssignedGoal assignGoal=new AssignedGoal();
		assignGoal.setEmployee(employee);
		assignGoal.setGoal(goal);
		assignGoal.setGoalStatus(false);
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		assignGoal.setStartDate(date);		
		
		assignedGoalRepository.save(assignGoal);
		
	}
	
	public Manager getManager(Employee employee) {
		
		return employee.getManager();
	}
	
	
	@Override
	public List<Goal> search(String keyword)
	{
		return goalRepository.search(keyword);
	}
}
