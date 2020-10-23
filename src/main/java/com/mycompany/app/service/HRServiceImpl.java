package com.mycompany.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Goal;
import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;
import com.mycompany.app.repository.EmployeeRepository;
import com.mycompany.app.repository.GoalRepository;
import com.mycompany.app.repository.HRRepository;
import com.mycompany.app.repository.ManagerRepository;

@Service
public class HRServiceImpl implements HRService {

	@Autowired
	GoalRepository goalRepository;
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	HRRepository hrRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Override
	public List<Goal> getAllGoals() {
		return goalRepository.findAll();
	}
	
	
	@Override
	public HR getHr(String username)
	{
		Optional<HR> hr=hrRepository.findByEmail(username);
		if(hr.isPresent())
			return hr.get();
		else
			return null;
	}
	
	@Override
	public List<Employee> getAllEmployees(Manager manager)
	{
		return empRepository.findByManager(manager);
	}
	
	@Override
	public Employee getEmployee(long id)
	{
		return empRepository.getOne(id);
	}
	
	
	@Override
	public List<Manager> getAllManagers(HR hr)
	{
		return managerRepository.findByHr(hr);
	}
	
	@Override
	public Manager getManager(long id)
	{
		return managerRepository.getOne(id);
	}
	
	
	@Override
	public Goal getGoal(Long id) {
		return goalRepository.getOne(id);
	}

	@Override
	public boolean saveGoal(Goal g) {
		try {
			goalRepository.save(g);
			return true;
		} catch(Exception ex) {
		    return false;
		}
	}
	@Override
	public void deleteGoal(Goal g)
	{
		goalRepository.delete(g);
	}
	@Override
	public void updateGoal(Goal g)
	{
		Goal temp=getGoal(g.getGoalId());
		temp.setGoalName(g.getGoalName());
		temp.setGoalDescription(g.getGoalDescription());
		temp.setGoalDuration(g.getGoalDuration());
		goalRepository.save(temp);
	}
	
	@Override
	public List<Employee> searchEmployee(String keyword)
	{
		return empRepository.searchEmployee(keyword);
	}
	
	
	@Override
	public List<Manager> searchManager(String keyword)
	{
		return managerRepository.searchManager(keyword);
		
	}
	
	
}
