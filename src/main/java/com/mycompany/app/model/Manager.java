package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Manager extends Person{
	
	@ManyToOne
	@JoinColumn(name = "hrId")
	private HR hr;
	
	@OneToOne
	@JoinColumn(name = "authorizationId")
	private Authorization authorization;
	
	
	public void setHr(HR hr) {
		this.hr = hr;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public HR getHr() {
		return hr;
	}

	public Authorization getAuthorization() {
		return authorization;
	}
}
