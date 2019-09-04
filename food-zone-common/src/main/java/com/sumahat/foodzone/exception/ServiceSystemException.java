package com.sumahat.foodzone.exception;

public class ServiceSystemException extends SystemException{
	
	
	ServiceSystemException(String message)
	{
		super(message);
	}
	ServiceSystemException(String message, String messageCode)
	{
		super(message, messageCode);
	}

}
