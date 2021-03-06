package com.deguzman.DeGuzmanStuffAnywhere.exception;

public class DuplicateBookNameException extends DeGuzmanStuffAnywhereException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5104092898234205115L;

	/**
	 * Exception class to handle invalid book names within the application
	 * 
	 * @param message
	 */
	public DuplicateBookNameException(String message) {
		super(message);
	}
}
