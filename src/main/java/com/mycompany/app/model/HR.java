package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class HR extends Person {

	@OneToOne
	@JoinColumn(name = "authorizationId")
	private Authorization authorization;
	
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	
	public Authorization getAuthorization() {
		return authorization;
	}
	
}
