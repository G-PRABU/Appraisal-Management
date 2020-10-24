package com.mycompany.app.pojo;

public class GoalRatingPOJO {

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
