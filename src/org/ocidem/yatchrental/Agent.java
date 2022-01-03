package org.ocidem.yatchrental;
import java.util.LinkedList;

public class Agent {
	public int id;
	public String name;
	private String password = "agent47";
	
	public void addYatch() {
		
	}
	
	public void viewYatchs() {
		
	}
	
	public void viewRentals() {
		
	}
	
	public void Init() {
		System.out.println("Hello user, please enter access password: ");
		String input = Utils.scanner.nextLine();
		if(password.equals(input)) {
			System.out.println("Hello agent, please select an option\n"
					+ "1) View yachts\n"
					+ "2) Add yacht\n"
					+ "3) View rentals");
			int selection = Utils.getSelection(3);
			switch(selection) {
			case 1:
				viewYatchs();
				break;
			case 2:
				addYatch();
				break;
			case 3:
				viewRentals();
				break;
			}
		}else {
			System.out.println("Wrong password! Try again: ");
			Init();
		}
	}
}