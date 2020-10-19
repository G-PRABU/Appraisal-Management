package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Employee extends Person{


	@ManyToOne
	@JoinColumn(name = "managerId")
	private Manager manager;
	
	@OneToOne
	@JoinColumn(name = "authorizationId")
	private Authorization authorization;
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
		
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	
	public Manager getManager() {
		return manager;
	}
		
	public Authorization getAuthorization() {
		return authorization;
	}
	
}
