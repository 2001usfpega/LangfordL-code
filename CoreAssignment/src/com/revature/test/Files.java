package com.revature.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Files {
	public static void readFile() {
		//StringBuilder s = new StringBuilder();
		try {
			Scanner x = new Scanner(new File("Data.txt")); 
			while(x.hasNextLine()) {
				String line = x.nextLine();
				String[] ind = line.split(":"); 
				System.out.println("Name: " + ind[0] + " " + ind[1]);
				System.out.println("Age: " + ind[2] + " years");
				System.out.println("State: " + ind[3] + " State");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}	

}
