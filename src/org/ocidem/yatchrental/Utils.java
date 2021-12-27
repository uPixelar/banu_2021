package org.ocidem.yatchrental;
import java.util.Scanner;

public class Utils {
	public static Scanner scanner = new Scanner(System.in);
	
	public static int getSelection(int selections) {
		int fails = 0;
		while(true) {
			switch(fails++) {//Easter egg
			case 5:
				System.out.println("C'mon, are you testing me or don't you know what is an integer ?");
				break;
			case 10:
				System.out.println("If you enter another wrong input, I'll kill myself");
				break;
			case 11:
				throw new Error("Program died...Probably because of you");
			}//Easter egg
			System.out.print(": ");
			String input = scanner.nextLine();
			int selection;
			try {
				selection = Integer.parseInt(input, 10);
				if(selection <= selections && selection > 0) return selection;	
				else System.out.println("(ERROR) Please enter an integer in range [1,"+selections+"]");
			}catch(NumberFormatException e) {
				System.out.println("(ERROR) Please enter an integer!");
			}
		}
	}
	
	public static String[] getCommand() {
		System.out.print(": ");
		String input = scanner.nextLine();
		return input.split("\s+");
	}
	
	public void test() {
		
	}
}
