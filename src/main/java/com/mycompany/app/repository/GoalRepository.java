package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    
}
