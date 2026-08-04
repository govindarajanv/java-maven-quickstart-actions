package com.work.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.work.service.exception.DivisionByZeroException;
import com.work.service.exception.WrongNumberOfArgumentsException;

@ControllerAdvice
@RestController
public class GlobalErrorController {

	@ExceptionHandler({ WrongNumberOfArgumentsException.class, DivisionByZeroException.class })
	public ResponseEntity<ErrorResponse> handleBadRequest(RuntimeException ex) {
		ErrorResponse error = new ErrorResponse("Bad Request", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
