package com.audree.audreeprintservice.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
	            ResourceNotFoundException ex, WebRequest request) {
	        
	        String path = request.getDescription(false).replace("uri=", "");
	        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

	        ErrorResponse errorResponse = new ErrorResponse(
	            ex.getMessage(),
	            path,
	            timestamp,
	            HttpStatus.NOT_FOUND.value()
	        );

	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
	        String path = request.getDescription(false).replace("uri=", "");
	        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

	        ErrorResponse errorResponse = new ErrorResponse(
	            "An unexpected error occurred",
	            path,
	            timestamp,
	            HttpStatus.INTERNAL_SERVER_ERROR.value()
	        );

	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
