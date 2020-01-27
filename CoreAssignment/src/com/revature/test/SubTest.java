package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubTest {

	@Test
	void test() {
		String input = "Lauren";
		int idx = 3;
		String actualOutput = Driver.subString(input, idx);
		String expectedOutput = input.substring(0,3);
		assertEquals(actualOutput,expectedOutput);
	}

}
