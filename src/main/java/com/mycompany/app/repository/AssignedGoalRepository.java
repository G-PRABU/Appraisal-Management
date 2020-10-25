package com.mycompany.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Goal;

public interface AssignedGoalRepository extends JpaRepository<AssignedGoal, Long> {

	public List<AssignedGoal> findByEmployee(Employee employee);
    public List<AssignedGoal> findByGoal(Goal goal);
}
