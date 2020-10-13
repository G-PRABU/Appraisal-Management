package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GoalRating {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long goalRatingId;
	
	private int onTimeCompletionScore;
	
	public void setGoalRatingId(Long id) {
		goalRatingId = id;
	}
	
	public void setOnTimeCompletionScore(int score) {
		onTimeCompletionScore = score;
	}
	
	public Long getGoalRatingId() {
		return goalRatingId;
	}
	
	public int getOnTimeCompletionScore() {
		return onTimeCompletionScore;
	}
	
}
