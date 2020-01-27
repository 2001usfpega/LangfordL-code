package com.revature.test;

public class Operations implements MathOperations{

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplliation(int a, int b) {
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		return a / b;
	}

	


}
