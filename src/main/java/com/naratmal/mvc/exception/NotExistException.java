package com.naratmal.mvc.exception;

/**
 * DB에 해당 정보가 존재하지 않을 때 발생하는 익셉션
 * */
public class NotExistException extends Exception {
	public NotExistException() {}
	
	public NotExistException(String message) {
		super(message);
	}
}
