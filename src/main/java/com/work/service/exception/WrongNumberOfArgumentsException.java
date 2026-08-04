package com.work.service.exception;

public class WrongNumberOfArgumentsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WrongNumberOfArgumentsException() {
		super("Wrong number of arguments. Expected at least 2.");
	}
}
