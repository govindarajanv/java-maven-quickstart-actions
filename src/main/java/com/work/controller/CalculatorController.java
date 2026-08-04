package com.work.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.function.Supplier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.work.service.CalculatorService;

@RestController
public class CalculatorController {

	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("/addition/{a}/{b}")
	public ResultResource getAddition(@PathVariable Integer a, @PathVariable Integer b) {
		return buildResult(calculatorService.add(a, b), () -> linkTo(methodOn(CalculatorController.class).getAddition(a, b)).withSelfRel());
	}

	@GetMapping("/addition/{a}/{b}/{c}")
	public ResultResource getAddition(@PathVariable Integer a, @PathVariable Integer b, @PathVariable Integer c) {
		return buildResult(calculatorService.add(a, b, c), () -> linkTo(methodOn(CalculatorController.class).getAddition(a, b, c)).withSelfRel());
	}

	@GetMapping("/subtraction/{a}/{b}")
	public ResultResource getSubtraction(@PathVariable Integer a, @PathVariable Integer b) {
		return buildResult(calculatorService.subtract(a, b), () -> linkTo(methodOn(CalculatorController.class).getSubtraction(a, b)).withSelfRel());
	}

	@GetMapping("/subtraction/{a}/{b}/{c}")
	public ResultResource getSubtraction(@PathVariable Integer a, @PathVariable Integer b, @PathVariable Integer c) {
		return buildResult(calculatorService.subtract(a, b, c), () -> linkTo(methodOn(CalculatorController.class).getSubtraction(a, b, c)).withSelfRel());
	}

	@GetMapping("/multiplication/{a}/{b}")
	public ResultResource getMultiplication(@PathVariable Integer a, @PathVariable Integer b) {
		return buildResult(calculatorService.multiply(a, b), () -> linkTo(methodOn(CalculatorController.class).getMultiplication(a, b)).withSelfRel());
	}

	@GetMapping("/multiplication/{a}/{b}/{c}")
	public ResultResource getMultiplication(@PathVariable Integer a, @PathVariable Integer b,
			@PathVariable Integer c) {
		return buildResult(calculatorService.multiply(a, b, c), () -> linkTo(methodOn(CalculatorController.class).getMultiplication(a, b, c)).withSelfRel());
	}

	@GetMapping("/division/{a}/{b}")
	public ResultResource getDivision(@PathVariable Integer a, @PathVariable Integer b) {
		return buildResult(calculatorService.divide(a, b), () -> linkTo(methodOn(CalculatorController.class).getDivision(a, b)).withSelfRel());
	}

	private ResultResource buildResult(Integer result, Supplier<org.springframework.hateoas.Link> selfLink) {
		ResultResource resultResource = new ResultResource(result);
		resultResource.add(selfLink.get());
		return resultResource;
	}
}
