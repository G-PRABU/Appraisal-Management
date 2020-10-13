package com.mycompany.app.exception;

public class GoalNotFoundException extends Exception {
    
	public GoalNotFoundException(int id) {
		super("Goal id is not found : "+id);
	}
}
