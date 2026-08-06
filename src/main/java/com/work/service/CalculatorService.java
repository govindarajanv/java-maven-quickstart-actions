package com.work.service;

import java.util.Arrays;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.work.service.exception.DivisionByZeroException;
import com.work.service.exception.WrongNumberOfArgumentsException;

/**
 * Performs basic math calculations on arrays of Integers.
 * Results are cached based on the operation and arguments.
 *
 * @author Lucas
 */
@Service
public class CalculatorService {

	@Cacheable("addition")
	public Integer add(Integer... numbers) {
		validate(numbers);
		return Arrays.stream(numbers).mapToInt(Integer::intValue).sum();
	}

	@Cacheable("subtraction")
	public Integer subtract(Integer... numbers) {
		validate(numbers);
		return Arrays.stream(numbers).mapToInt(Integer::intValue).reduce((a, b) -> a - b).orElse(0);
	}

	@Cacheable("multiplication")
	public Integer multiply(Integer... numbers) {
		validate(numbers);
		return Arrays.stream(numbers).mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
	}

	@Cacheable("division")
	public Integer divide(Integer a, Integer b) {
		if (b == 0) {
			throw new DivisionByZeroException();
		}
		return a / b;
	}

	private void validate(Integer... numbers) {
		if (numbers.length < 2) {
			throw new WrongNumberOfArgumentsException();
		}
	}
}
