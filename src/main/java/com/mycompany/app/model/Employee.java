package com.mycompany.app.model;;

public class Employee {
    public String name;
    public String dept;
    public String phone;
    
    public Employee(String name,String dept,String phone) {
    	this.name = name;
    	this.dept = dept;
    	this.phone = phone;
    }
    
    public String getName() {
    	return name;
    }
}
