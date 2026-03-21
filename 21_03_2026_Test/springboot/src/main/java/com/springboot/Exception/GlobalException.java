package com.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(DuplicateEntryException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String duplicateEntry(DuplicateEntryException exp) {
		return exp.getMessage();
	}
}
