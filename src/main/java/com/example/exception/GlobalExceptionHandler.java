package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionBean> emploeeExceptionHandler(EmployeeNotFoundException e){
		ExceptionBean bean=new ExceptionBean();
		
		bean.setMsg(e.getMessage());
		bean.setCode("ABCDEFGH");
		
		return new ResponseEntity<ExceptionBean>(bean,HttpStatus.NOT_FOUND);
	}

}
