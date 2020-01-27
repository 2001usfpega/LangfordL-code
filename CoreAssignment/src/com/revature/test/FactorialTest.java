package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	void test() {
		int n = 6;
		int actualOutput = Driver.nFactorial(n);
		int expectedOutput = 720;
		assertEquals(actualOutput,expectedOutput);
	}

}
