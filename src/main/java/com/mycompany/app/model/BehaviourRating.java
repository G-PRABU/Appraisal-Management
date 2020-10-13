package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BehaviourRating {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long behaviourRatingId;
	
	private int communicationScore;
	
	public void setBehaviourRatingId(Long id) {
		behaviourRatingId = id;
	}
	
	public void setCommunicationScore(int score) {
		communicationScore = score;
	}
	
	public Long getBehaviourRatingId() {
		return behaviourRatingId;
	}
	
	public int getCommunicationScore() {
		return communicationScore;
	}
}
