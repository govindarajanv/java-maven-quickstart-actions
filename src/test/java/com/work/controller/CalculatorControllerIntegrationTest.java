package com.work.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.work.controller.ResultResource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	// --- Addition ---

	@Test
	void testGetAdditionTwoArguments() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/addition/2/3",
				ResultResource.class);
		assertEquals(5, resultResource.getResult());
	}

	@Test
	void testGetAdditionThreeArguments() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/addition/2/3/1",
				ResultResource.class);
		assertEquals(6, resultResource.getResult());
	}

	@Test
	void testGetAdditionNegativeNumbers() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/addition/-5/3",
				ResultResource.class);
		assertEquals(-2, resultResource.getResult());
	}

	// --- Subtraction ---

	@Test
	void testGetSubtractionTwoArguments() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/subtraction/2/3",
				ResultResource.class);
		assertEquals(-1, resultResource.getResult());
	}

	@Test
	void testGetSubtractionThreeArguments() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/subtraction/2/3/1",
				ResultResource.class);
		assertEquals(-2, resultResource.getResult());
	}

	// --- Multiplication ---

	@Test
	void testGetMultiplicationTwoArguments() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/multiplication/2/3",
				ResultResource.class);
		assertEquals(6, resultResource.getResult());
	}

	@Test
	void testGetMultiplicationThreeArguments() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/multiplication/2/3/2",
				ResultResource.class);
		assertEquals(12, resultResource.getResult());
	}

	@Test
	void testGetMultiplicationWithZero() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/multiplication/0/5",
				ResultResource.class);
		assertEquals(0, resultResource.getResult());
	}

	// --- Division ---

	@Test
	void testGetDivision() {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/division/6/3",
				ResultResource.class);
		assertEquals(2, resultResource.getResult());
	}

	@Test
	void testGetDivisionByZero() {
		ResponseEntity<ErrorResponse> response = restTemplate.getForEntity(
				getPath() + "/division/2/0", ErrorResponse.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	// --- Error Handling ---

	@Test
	void testBadRequestOnNonIntegerPath() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				getPath() + "/addition/abc/2", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	void testNotFoundOnUnknownEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				getPath() + "/addition/999", String.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testActuatorHealthEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				getPath() + "/actuator/health", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	private String getPath() {
		return "http://localhost:" + port;
	}
}
