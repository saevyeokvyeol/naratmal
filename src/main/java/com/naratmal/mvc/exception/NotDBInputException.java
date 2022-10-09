package com.naratmal.mvc.exception;

/**
 * DB에 정보가 입력되지 않았을 때 발생하는 익셉션
 * */
public class NotDBInputException extends Exception {
	public NotDBInputException() {}
	
	public NotDBInputException(String message) {
		super(message);
	}
}
