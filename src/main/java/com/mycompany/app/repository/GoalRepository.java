package com.mycompany.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.app.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    
	@Query(value="SELECT g from Goal g where g.goalName LIKE '%' || :keyword || '%' ")
	public List<Goal> search(@Param("keyword") String keyword);

}
