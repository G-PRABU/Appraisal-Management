package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.AssignedGoal;

public interface AssignedGoalRepository extends JpaRepository<AssignedGoal, Long> {

}
