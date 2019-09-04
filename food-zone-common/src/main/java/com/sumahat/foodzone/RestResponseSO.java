package com.sumahat.foodzone;

import org.joda.time.DateTime;

public class RestResponseSO {
	private String timestamp;
	private String result;
	private String message;
	private String messageCode;
	private int rowCount;
	private int totalRowCount;
	Object data;

	public RestResponseSO() {
		this.result = Result.SUCCESS.toString();
		this.timestamp = new DateTime().toString();
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public void updateResult(Result result) {
		this.result = result==result.SUCCESS?result.SUCCESS.toString():result.ERROR.toString();
	}

	public void updateMessage(String message, String messageCode) {
		this.message = message;
		this.messageCode = messageCode;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public enum Result{
		SUCCESS, ERROR
	}

}
