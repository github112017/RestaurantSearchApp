package com.sumahat.foodzone.exception;

public class AuthorizationException extends SystemException {

	AuthorizationException(String message) {
		super(message);
	}

	AuthorizationException(String message, String messageCode) {
		super(message, messageCode);
	}

}
