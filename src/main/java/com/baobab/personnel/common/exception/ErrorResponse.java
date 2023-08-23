package com.baobab.personnel.common.exception;

public enum ErrorResponse implements Error{
	
	REPONSE_SUCCESS("200", "OK","200"), 
	REPONSE_UNSUCCESS("111", "KO","111");
	
	String code, message, status;

	private ErrorResponse(String code, String message, String status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage(String msg) {
		return msg + " "+message;
	}

	@Override
	public String getStatus() {
		return status;
	}	
	
}