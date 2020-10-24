package com.mycompany.app.pojo;

import com.mycompany.app.model.Authorization;
import com.mycompany.app.model.HR;

public class ManagerPOJO extends PersonPOJO{

	private HR hr;
	
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
