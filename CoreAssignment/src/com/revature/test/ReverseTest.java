package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseTest {

	@Test
	void test() {
		String input = "Lauren";
		String actualOutput = Driver.reverseString(input);
		StringBuilder input1 = new StringBuilder();
		input1.append(input);
		String expectedOutput = input1.reverse().toString();
		assertEquals(actualOutput,expectedOutput);
	}

}
