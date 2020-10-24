package com.mycompany.app.pojo;

public class GoalPOJO {

    private Long goalId;
	
	private String goalName;
	
	private String goalDescription;
	
	private Integer goalDuration;
	
	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}
	
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	
	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}
	
	public void setGoalDuration(Integer goalDuration) {
		this.goalDuration = goalDuration;
	}
	
	public Long getGoalId() {
		return goalId;
	}
	
	public String getGoalName() {
		return goalName;
	}
	
	public String getGoalDescription() {
		return goalDescription;
	}
	
	public Integer getGoalDuration() {
		return goalDuration;
	}

}
