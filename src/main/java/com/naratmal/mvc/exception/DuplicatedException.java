package com.naratmal.mvc.exception;
/**
 * 아이디 등이 중복되었을 때 발생하는 익셉션
 * */
public class DuplicatedException extends Exception {
	public DuplicatedException() {}
	
	public DuplicatedException(String message) {
		super(message);
	}
}
