package com.in28minutes.REST.webServices.restfulwebservices.exeption;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityExeptionHandler extends ResponseEntityExceptionHandler 
{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handelException( Exception ex , WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now() , ex.getMessage() , request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserPrincipalNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handelUserNotFoundException( Exception ex , WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now() , ex.getMessage() , request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Nullable @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now() ," Error Number is :"+ex.getErrorCount()+" & First Error is :"+ ex.getFieldError().getDefaultMessage() , request.getDescription(false));
		
		
		
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}


}
