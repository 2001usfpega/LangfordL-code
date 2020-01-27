package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinimumTest {

	@Test
	void test() {
		int num1 = 234;
		int num2 = 89;
		int actualOutput = Driver.minNums(num1, num2);
		int expectedOutput = num2;
		assertEquals(actualOutput,expectedOutput);
	}

}
