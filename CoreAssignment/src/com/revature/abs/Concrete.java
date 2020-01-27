package com.revature.abs;

public class Concrete extends DiffMethods{

	@Override
	public boolean ifUpper(String word) {
		char[] charArray = word.toCharArray();
		for(char i:charArray){
			if(Character.isUpperCase(i)) {
				return true;
			}
		}
		return false;		
	}

	@Override
	public String toUpper(String word) {
		return word.toUpperCase();
		
	}

	@Override
	public int stringToInt(String number) {
		int stringNum = Integer.parseInt(number);
		return stringNum + 10;
		
	}

}
