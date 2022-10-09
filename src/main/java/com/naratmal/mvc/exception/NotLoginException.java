package com.naratmal.mvc.exception;

/**
 * 로그인이 하지 않았을 때 발생하는 익셉션
 * */
public class NotLoginException extends Exception {
	public NotLoginException() {}
	
	public NotLoginException(String message) {
		super(message);
	}
}
