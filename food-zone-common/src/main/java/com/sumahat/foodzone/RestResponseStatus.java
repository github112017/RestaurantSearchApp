package com.sumahat.foodzone;

import javax.ws.rs.core.Response.Status;

public interface RestResponseStatus {

	static final Status OK =  Status.OK;
	static final Status BAD_REQUEST = Status.BAD_REQUEST;
	static final Status INTERNAL_SERVER_ERROR = Status.INTERNAL_SERVER_ERROR;
	static final Status FORBIDDEN_ERROR= Status.FORBIDDEN;
}
