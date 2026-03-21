package com.springboot.Exception;

public class DuplicateEntryException extends RuntimeException{
	public DuplicateEntryException(String msg) {
		super(msg);
	}
}
