package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class HR {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long hrId;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Employee hr;
	
	public void setHrId(Long id) {
		hrId = id;
	}
	
	public void setHr(Employee hr) {
		this.hr = hr;
	}
	
	public Long getHrId() {
		return hrId;
	}
	
	public Employee getHr() {
		return hr;
	}
	
}
