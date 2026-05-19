package com.example.MatrimonyManagement.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.MatrimonyManagement.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex){
		
		Map<String , String> errors= new HashMap<String, String>();
		
		ex.getBindingResult()
			.getFieldErrors()
			.forEach(error -> 
					errors.put(error.getField(), error.getDefaultMessage())
			);
		
		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now()
				);	
	
		return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<ErrorResponse> handleDataBaseException(DataBaseException ex){
		
		ErrorResponse error = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(),
				LocalDateTime.now()
				
				);
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				
		
	}
	
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex){
		
		ErrorResponse error = new ErrorResponse(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				LocalDateTime.now()
				);
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				
		
	}
	
	
	
	
	
	
	
	
	
	
}
