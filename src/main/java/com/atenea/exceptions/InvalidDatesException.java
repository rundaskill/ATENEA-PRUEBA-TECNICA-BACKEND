package com.atenea.exceptions;

public class InvalidDatesException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDatesException(String message) {
        super(message);
    }
}