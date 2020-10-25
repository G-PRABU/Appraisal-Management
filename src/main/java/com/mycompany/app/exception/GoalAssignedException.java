package com.mycompany.app.exception;

public class GoalAssignedException extends Exception {
	
	private static final long serialVersionUID = 5888683701681150964L;

	public GoalAssignedException(long id) {
		super("Goal can't be deleted with id : "+ id);
	}
}
