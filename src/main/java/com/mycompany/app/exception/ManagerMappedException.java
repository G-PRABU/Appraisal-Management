package com.mycompany.app.exception;

public class ManagerMappedException extends Exception {
	
	private static final long serialVersionUID = 3120800523052999550L;

	public ManagerMappedException(long id) {
    	super("Manager can't be deleted with id : "+ id);
    }
}
