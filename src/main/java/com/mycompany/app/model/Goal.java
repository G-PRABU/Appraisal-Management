package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
