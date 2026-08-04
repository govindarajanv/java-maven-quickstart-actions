package com.work.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.service.CalculatorService;
import com.work.service.exception.DivisionByZeroException;
import com.work.service.exception.WrongNumberOfArgumentsException;

@RestController
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@RequestMapping("/addition/{a}/{b}")
	public ResultResource getAddition(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
		Integer result = calculatorService.add(a, b);
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(linkTo(methodOn(CalculatorController.class).getAddition(a, b)).withSelfRel());
		return resultResource;
	}

	@RequestMapping("/addition/{a}/{b}/{c}")
	public ResultResource getAddition(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b,
			@PathVariable(name = "c") Integer c) {
		Integer result = calculatorService.add(a, b, c);
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(linkTo(methodOn(CalculatorController.class).getAddition(a, b, c)).withSelfRel());
		return resultResource;
	}

	@RequestMapping("/subtraction/{a}/{b}")
	public ResultResource getSubtraction(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
		Integer result = calculatorService.subtract(a, b);
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(linkTo(methodOn(CalculatorController.class).getSubtraction(a, b)).withSelfRel());
		return resultResource;
	}

	@RequestMapping("/subtraction/{a}/{b}/{c}")
	public ResultResource getSubtraction(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b,
			@PathVariable(name = "c") Integer c) {
		Integer result = calculatorService.subtract(a, b, c);
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(linkTo(methodOn(CalculatorController.class).getSubtraction(a, b, c)).withSelfRel());
		return resultResource;
	}

	@RequestMapping("/multiplication/{a}/{b}")
	public ResultResource getMultiplication(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
		Integer result = calculatorService.multiply(a, b);
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(linkTo(methodOn(CalculatorController.class).getMultiplication(a, b)).withSelfRel());
		return resultResource;
	}

	@RequestMapping("/multiplication/{a}/{b}/{c}")
	public ResultResource getMultiplication(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b,
			@PathVariable(name = "c") Integer c) {
		Integer result = calculatorService.multiply(a, b, c);
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(linkTo(methodOn(CalculatorController.class).getMultiplication(a, b, c)).withSelfRel());
		return resultResource;
	}

	@RequestMapping("/division/{a}/{b}")
	public ResultResource getDivision(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
		Integer result = calculatorService.divide(a, b);
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(linkTo(methodOn(CalculatorController.class).getDivision(a, b)).withSelfRel());
		return resultResource;
	}

	@ExceptionHandler({ WrongNumberOfArgumentsException.class, DivisionByZeroException.class })
	public ResponseEntity<ErrorResponse> handleBadRequest(RuntimeException ex) {
		ErrorResponse error = new ErrorResponse("Bad request", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
