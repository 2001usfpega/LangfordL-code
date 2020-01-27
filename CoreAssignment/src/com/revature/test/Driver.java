package com.revature.test;

import java.util.*;
import java.io.*;

import com.revature.abs.Concrete;
import com.revature.compares.*;
import com.revature.floats.AccessFloatVars;

public class Driver {
	public static void main(String[] args) {
		//Q1
		//bubbleSort();
		//Q2
		//fibonacci25();
		//Q3
		//System.out.println(reverseString("Lauren"));		
		//Q4
		//System.out.println(nFactorial(6));
		//Q5
		//System.out.println(subString("Lauren", 3));
		//System.out.println("Lauren".substring(0,3));
		//Q6
		//System.out.println(isEven(-2));
		//Q7
		//compareEmployees();
		//Q8
		//palindromeArray();
		//Q9
		//System.out.println(isPrime(3));
		//primeNums();
		//Q10
		//minNums(40,8);
		//Q11
		//diffPackage();
		//Q12
		//evenArray();
		//Q13
		//triangle();		
		//Q14
		//switchDemo(4);
		//Q17
		//System.out.println(simpleInterest());
		//Q18		
		//Concrete test = new Concrete();
		//System.out.println(test.ifUpper("Lauren"));
		//System.out.println(test.toUpper("lauren"));
		//System.out.println(test.stringToInt("88"));
		//Q19
		//numbers();
		//Q20
		//Files txt = new Files();
		//txt.readFile();
		
	}
	
	//Q1
	public static void bubbleSort() { //COMMENT!!
		int[] bubbleArray = {1,0,5,6,3,2,3,7,9,8,4};
		for(int i = 0; i < bubbleArray.length-1; i++) {
			for(int j = 0; j < bubbleArray.length-i-1; j++) {
				if(bubbleArray[j] > bubbleArray[j+1]) {
					int hold = bubbleArray[j];
					bubbleArray[j] = bubbleArray[j+1];
					bubbleArray[j+1] = hold;
				}
			}
		}
		for(int i:bubbleArray) {
			System.out.print(i + " ");
		}
		
	}
	
	
	//Q2
	public static void fibonacci25() {
		int[] fibArray = new int[25]; //creates array length 25
		fibArray[0] = 0;
		fibArray[1] = 1;
		for(int i = 2; i < 25; i++) { //definition of Fibonacci: x_n = x_(n-1)+x_(n-2)
			fibArray[i] = fibArray[i-1] + fibArray[i-2];
		}
		for(int i:fibArray) {
			System.out.println(i);//prints out array elements
		}
	}
	
	
	//Q3
	public static String reverseString(String str) { //COMMENT!!
		String finalStr = "";
		for(int i = str.length()-1; i >= 0; i--) {
			finalStr += str.charAt(i);
		}
		return finalStr;
	}
	
	
	//Q4
	public static int nFactorial(int n) {
		int result = 1;
		int c = 0;// counter
		if(n == 0) {
			result = result; //0! = 1
		}
		else if(n > 0) {
			while(c != n) { //for numbers > 0, multiply (n-c) result by previous result
				result *= (n - c); 
				c++; //increment c until c = n
			}
		}
		return result;
	}

	
	//Q5
	public static String subString(String str, int idx) { //COMMENT!!
		String finalStr = "";
		int i = 0;
		while(i <= idx-1) {
			finalStr += str.charAt(i);
			i++;
		}
		return finalStr;
	}	
	
	
	//Q6
	public static boolean isEven(int num) {
		//check if INTEGER is even
		int quotient = num/2;
		//will have to be integer so if number is odd, quotient*2 won't return same number
		//System.out.println(quotient);
		if(quotient*2== num){ 
			return true;}
		return false;}
	
	
	//Q7
	public static void compareEmployees() { //COMMENT!!
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("Mary Hall", "English", 29));
		employeeList.add(new Employee("Eugene Smith", "Math",35));
		
		System.out.println("Sorted by Name:");
		Collections.sort(employeeList, new NameComparator());
		for(Employee e:employeeList) {
			System.out.println(e);
		}
		System.out.println("\nSorted by Department:");
		Collections.sort(employeeList, new DeptComparator());
		for(Employee e:employeeList) {
			System.out.println(e);
		}
		System.out.println("\nSorted by Age:");
		Collections.sort(employeeList, new AgeComparator());
		for(Employee e:employeeList) {
			System.out.println(e);
		}
	}
	
	
	//Q8
	public static boolean isPalindrome(String word) { //COMMENT!!
		int c = 0;
		while(c <= word.length()/2) {
			if(word.charAt(c) != word.charAt(word.length() - 1 - c)) {
				return false;										
			}
			c++;
		}
		return true;
	}
	public static void palindromeArray() {
		List<String> words = Arrays.asList("karan","madam","tom","civic","radar","jimmy","kayak","john","refer","billy","did");
		ArrayList<String> wordsList = new ArrayList<>(); //creates new ArrayList for given words
		wordsList.addAll(words); //adds all words from List words to ArrayList wordsList
		ArrayList<String> palindromes = new ArrayList<String>(); //creates new ArrayList for palindromes
		for(String i:words) {
			if(isPalindrome(i)) { //checks if word is palindrome 
				palindromes.add(i); //adds word to palindrome ArrayList if true
			}
		}
		for(String i:palindromes) {
			System.out.println(i); //prints list element
		}
	}
	
	
	//Q9
	//should probably create a isPrime method since another question deals with prime
	public static boolean isPrime(int num) { //COMMENT!!
		if (num <= 1) {
			return false;
		}
		int i = 2;
		while(i < num) {
			if(num % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
	public static void primeNums() {
		ArrayList<Integer> hundredArray = new ArrayList<Integer>(); //creates new Array List
		for(int i = 0; i < 100; i++) {
			hundredArray.add(i+1); //adds 1-100 to ArrayList
		}		
		for(int i:hundredArray) {
			if(isPrime(i)) { //calls isPrime method
				System.out.println(i); //prints out number if prime
			}
			
		}		
	}	

	
	//Q10
	public static int minNums(int a, int b) {
		int min;
		min = (a < b) 
					? a //if a < b, then a
					: b; // if a not < b = b < a, then b
		return min;
	}
	
	
	//Q11
	public static void diffPackage() {
		AccessFloatVars fv = new AccessFloatVars();
		System.out.println("The sum of the two numbers is " + (fv.f1 + fv.f2));
	}

	
	//Q12
	public static void evenArray() {
		int[] hundredArray = new int[100]; //creates array length 100
		for(int i = 0; i < hundredArray.length; i++) {
			hundredArray[i] = i + 1; //adds 1-100 to array
		}
		for(int i: hundredArray) {
			if(i % 2 == 0) {
				System.out.println(i); //prints number if even number
			}
		}		
	}

	
	//Q13
	public static void triangle() {
		int num = 0;
		for(int i=1;i<=4;i++){
			for(int j=1;j<=i;j++){
				System.out.print(num);
				num = 1 - num;
			}
		System.out.println();
		}	
	}

	
	//Q14
	public static void switchDemo(int num) { //COMMENT!!
		switch(num) {
		case 1:
			Scanner number = new Scanner(System.in);
			System.out.println("Enter a number to evaluate its square root.");
			double x = number.nextDouble();
			System.out.println(Math.sqrt(x));
			break;
		case 2:
			Date date = new Date();
			System.out.println(date);
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] strArray = str.split(" ");
			for(String i:strArray) {
				System.out.println(i);
			}
			break;
		default:
			System.out.println("This is not one of the cases.");		
		}
	}
	
	
	//Q15
	
	
	//Q16
	
	
	//Q17	
	public static double simpleInterest() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter values for principal, rate, and time, respectively"); //tells user to input values
		double principal = input.nextDouble(); //principal value input - used double in case not rounded value
		double rate = input.nextDouble(); //rate input
		int time = input.nextInt(); //time input - integer years or months
		
		return principal * rate * time;	
	}
	
	
	//Q18
	
	
	//Q19	
	public static void numbers() { // COMMENT!!
		ArrayList<Integer> tenArray = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			tenArray.add(i+1); //adds 1-10 to ArrayList
		}
		System.out.println(tenArray);
		int evenSum = 0;
		int oddSum = 0;
		for(int i:tenArray) {
			if(i%2 == 0) {
				evenSum += i;
			}
			else if(i%2 != 0) {
				oddSum += i;
			}
		}
		System.out.println("The sum of all even numbers is " + evenSum + ".");
		System.out.println("The sum of all odd numbers is " + oddSum + ".");
		
		ListIterator<Integer> litr = tenArray.listIterator();
		while(litr.hasNext()) {
			int i = litr.next();
			if(isPrime(i)) {
				litr.remove();
			}
		}
		System.out.println(tenArray);
	}
		
		
}
	
	
	




