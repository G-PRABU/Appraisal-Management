package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.GoalRating;

public interface GoalRatingRepository extends JpaRepository<GoalRating,Long>{

}
