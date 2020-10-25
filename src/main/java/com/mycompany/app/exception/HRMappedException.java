package com.mycompany.app.exception;

public class HRMappedException extends Exception {

	private static final long serialVersionUID = 8316945956210070509L;

	public HRMappedException(long id) {
		super("HR Can't be deleted with id : "+ id);
	}
}
