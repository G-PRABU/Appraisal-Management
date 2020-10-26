package com.mycompany.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AssignedGoal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long assignedGoalId;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "goalId")
	private Goal goal;
	
	@OneToOne
	@JoinColumn(name = "goalRatingId")	
	private GoalRating goalRating;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
    private boolean goalStatus;
    
	public void setAssignedGoalId(Long id) {
		assignedGoalId = id;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	public void setGoalRating(GoalRating goalRating) {
		this.goalRating = goalRating;
	}
	
	public void setStartDate(Date date) {
		startDate = date;
	}
	
	public void setEndDate(Date date) {
		endDate = date;
	}
	
	public void setGoalStatus(boolean goalStatus) {
		this.goalStatus = goalStatus;
	}
	
	public Long getAssignedGoalId() {
		return assignedGoalId;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public Goal getGoal() {
		return goal;
	}
	
	public GoalRating getGoalRating() {
		return goalRating;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public boolean isGoalStatus() {
		return goalStatus;
	}
    	
}
