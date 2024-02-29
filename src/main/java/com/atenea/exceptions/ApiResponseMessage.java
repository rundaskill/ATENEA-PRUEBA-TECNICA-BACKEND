package com.atenea.exceptions;

public class ApiResponseMessage extends RuntimeException {
	 private int statusCode;
	 private String message;

    public ApiResponseMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
