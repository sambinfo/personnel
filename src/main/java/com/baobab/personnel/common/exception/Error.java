package com.baobab.personnel.common.exception;

public interface Error {
	public String getCode();
	public String  getMessage(String msg);
	public String  getStatus();
	public String name();
}
