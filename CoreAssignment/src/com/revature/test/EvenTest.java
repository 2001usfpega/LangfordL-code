package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvenTest {

	@Test
	void test() {
		boolean actualOutput = Driver.isEven(6);
		boolean expectedOutput = true;
		assertEquals(actualOutput,expectedOutput);
		
	}

}
