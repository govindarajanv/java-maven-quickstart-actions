package com.work.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.work.service.CalculatorService;
import com.work.service.exception.DivisionByZeroException;
import com.work.service.exception.WrongNumberOfArgumentsException;

class CalculatorServiceTest {

	private CalculatorService calculatorService = new CalculatorService();

	@Test
	void testCreation() {
		assertNotNull(calculatorService);
	}

	@Test
	void testAddWithNoParams() {
		assertThrows(WrongNumberOfArgumentsException.class, () -> calculatorService.add());
	}

	@Test
	void testAddOneParam() {
		assertThrows(WrongNumberOfArgumentsException.class, () -> calculatorService.add(1));
	}

	@Test
	void testAdd() {
		assertEquals(Integer.valueOf(5), calculatorService.add(1, 4));
	}

	@Test
	void testSubtractWithNoParams() {
		assertThrows(WrongNumberOfArgumentsException.class, () -> calculatorService.subtract());
	}

	@Test
	void testSubtractOneParam() {
		assertThrows(WrongNumberOfArgumentsException.class, () -> calculatorService.subtract(5));
	}

	@Test
	void testSubtract() {
		assertEquals(Integer.valueOf(-3), calculatorService.subtract(1, 4));
	}

	@Test
	void testMultiplyWithNoParams() {
		assertThrows(WrongNumberOfArgumentsException.class, () -> calculatorService.multiply());
	}

	@Test
	void testMultiplyOneParam() {
		assertThrows(WrongNumberOfArgumentsException.class, () -> calculatorService.multiply(1));
	}

	@Test
	void testMultiply() {
		assertEquals(Integer.valueOf(4), calculatorService.multiply(1, 4));
	}

	@Test
	void testDivide() {
		assertEquals(Integer.valueOf(6), calculatorService.divide(12, 2));
	}

	@Test
	void testDivideByZero() {
		assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(12, 0));
	}
}
