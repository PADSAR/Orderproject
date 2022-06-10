package com.order.exceptions;

import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(NoSuchOrderFound.class)
	public ResponseEntity<ExceptionResponce>handleNoSuchOrderFound(NoSuchOrderFound e){
		ExceptionResponce error = new ExceptionResponce("",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderWithIdAlreadyExist.class)
	public ResponseEntity<ExceptionResponce>handleNoSuchOrderFound(OrderWithIdAlreadyExist e){
		ExceptionResponce error = new ExceptionResponce("duplicate id",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.CONFLICT);
	}
	

}
