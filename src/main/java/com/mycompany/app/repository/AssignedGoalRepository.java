package com.mycompany.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;

public interface AssignedGoalRepository extends JpaRepository<AssignedGoal, Long> {

	public List<AssignedGoal> findByEmployee(Employee employee);

}
