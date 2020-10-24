package com.mycompany.app.pojo;

import com.mycompany.app.model.Authorization;
import com.mycompany.app.model.Manager;

public class EmployeePOJO extends PersonPOJO{

	private Manager manager;
	
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
