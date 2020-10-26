package com.mycompany.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.GoalRating;
import com.mycompany.app.model.Manager;
import com.mycompany.app.repository.AssignedGoalRepository;
import com.mycompany.app.repository.EmployeeRepository;
import com.mycompany.app.repository.GoalRatingRepository;
import com.mycompany.app.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	ManagerRepository managerRepository;
    
	@Autowired
	GoalRatingRepository goalRatingRepository;
	
	@Autowired
	AssignedGoalRepository assignedGoalRepository;
	
	@Override
	public Manager getManager(Long id) {
		Optional<Manager> manager = managerRepository.findById(id);
		if(manager.isPresent()) {
			return manager.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees(Manager manager) {
		return employeeRepository.findByManager(manager);
	}

	@Override
	public Collection<Manager> getAllManagers() {
		return managerRepository.findAll();
	}

	@Override
	public Manager getManager(String email) {
		Optional<Manager> manager = managerRepository.findByEmail(email);
		if(manager.isPresent()) {
			return manager.get();
		}
		return null;
	}

	@Override
	public List<Employee> searchEmployees(String keyword) {
		return employeeRepository.searchEmployee(keyword);
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public boolean saveRating(GoalRating goalRating,long id) {
		try {
			int totalScore=goalRating.getOnTimeCompletionScore()+goalRating.getProblemSolvingScore()+goalRating.getResponsibilityScore()+goalRating.getWorkEfficiencyScore()+goalRating.getTeamCollaborationScore();
			goalRating.setTotalScore(totalScore*100/25);
			goalRatingRepository.save(goalRating);
			AssignedGoal assignedGoal=assignedGoalRepository.getOne(id);
			assignedGoal.setGoalRating(goalRating);
			
			assignedGoalRepository.save(assignedGoal);
			
			return true;
		} catch(Exception ex) {
		    return false;
		}
	}
}
