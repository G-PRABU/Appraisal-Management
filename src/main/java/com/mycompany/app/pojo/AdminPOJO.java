package com.mycompany.app.pojo;

import com.mycompany.app.model.Authorization;

public class AdminPOJO extends PersonPOJO {

	private Authorization authorization;
	
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	
	public Authorization getAuthorization() {
		return authorization;
	}
}
