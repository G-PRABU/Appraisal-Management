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
	
	private int teamCollaborationScore;
	
	private int problemSolvingScore;
	
	private int responsibilityScore;
	
	private int workEfficiencyScore;
	
	private int totalScore;
	
	public int getTeamCollaborationScore() {
		return teamCollaborationScore;
	}

	public void setTeamCollaborationScore(int teamCollaborationScore) {
		this.teamCollaborationScore = teamCollaborationScore;
	}

	public int getProblemSolvingScore() {
		return problemSolvingScore;
	}

	public void setProblemSolvingScore(int problemSolvingScore) {
		this.problemSolvingScore = problemSolvingScore;
	}

	public int getResponsibilityScore() {
		return responsibilityScore;
	}

	public void setResponsibilityScore(int responsibilityScore) {
		this.responsibilityScore = responsibilityScore;
	}

	public int getWorkEfficiencyScore() {
		return workEfficiencyScore;
	}

	public void setWorkEfficiencyScore(int workEfficiencyScore) {
		this.workEfficiencyScore = workEfficiencyScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

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
