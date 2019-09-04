package com.sumahat.foodzone.exception;

import java.util.List;

public class SystemException extends Exception{
	
	private String message, messageCode;
	private static final String DEFAULT_MESSAGE = "No Message set";
	private static final String DEFAULT_MESSAGE_CODE ="fz - Undefined";
    private static List<ErrorMessage> errorList;
	
	public SystemException() {
        super();
	}
	public SystemException(String message) {
		super(message);
		setMessage(message);
	    this.message = getMessage();
	}
	public SystemException(String message, Throwable t) {
		super(message, t);
		setMessage(message);
	    this.message = getMessage();
		
	}
	public SystemException(String message, String messageCode) {
		super(message);
		setMessage(message);
		setMessageCode(messageCode);
		this.message = getMessage();
		this.messageCode =  getMessageCode();
	}
	
	public SystemException(List<ErrorMessage> errorMessages) {
		super();
		setErrorList(errorMessages);
		
	}
	public String getMessage() {
		if(message!=null)
		return message;
		else
			return getDefaultMessage();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageCode() {
		if(messageCode!=null)
		return messageCode;
		else
			return getDefaultMessageCode();
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public static List<ErrorMessage> getErrorList() {
		return errorList;
	}

	public static void setErrorList(List<ErrorMessage> errorList) {
		SystemException.errorList = errorList;
	}

	public static String getDefaultMessage() {
		return DEFAULT_MESSAGE;
	}

	public static String getDefaultMessageCode() {
		return DEFAULT_MESSAGE_CODE;
	}
	
	
}
