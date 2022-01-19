package org.ocidem.yatchrental;
import java.util.ArrayList;

public class Agent {
	public int id;
	public String name;
	private String password = "agent47";
	
	public void addYatch() {
		String model = Utils.scanner.nextLine();
		String color = Utils.scanner.nextLine();
		float price = Utils.scanner.nextFloat();
		YatchRental.getOffice().addYatch(model, color, price);
	}
	
	public void viewYatchs() {
		ArrayList<Yatch> yatchs = YatchRental.getOffice().getAllYatchs();
		int size = yatchs.size();
		for(int i=0; i<size; i++) {
			Yatch yatch = yatchs.get(i);
			System.out.println(String.format("%s) %s : %s, %s", i+1, yatch.model, Utils.formatPrice(yatch.price), yatch.isRent?"Rented":"Free"));
		}
		String[] args = Utils.getCommand();
		switch(args[0]) {
			case "delete":
				if(args.length > 1) {
					int selection = Integer.parseInt(args[1]);
					YatchRental.getOffice().removeYatch(yatchs.get(selection-1).id);
				}
		}
	}
	
	public void viewRentals() {
		
	}
	
	public void CommandInterface() {
		while(true) {
			String[] args = Utils.getCommand();
			if(args.length > 0) {
				switch(args[0]) {
				case "help":
					System.out.println(
						"help		- view help message\n"
						+ "yatchs		- view all yatchs\n"
						+ "addyatch		- add yatch\n"
						+ "rentals		-view rentals"
					);
				}
			}
		}
	}
	
	public void Init() {
		System.out.println("Hello user, please enter access password: ");
		String input = Utils.scanner.nextLine();
		if(password.equals(input)) {
			CommandInterface();
			/*
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
			}*/
		}else {
			System.out.println("Wrong password! Try again: ");
			Init();
		}
	}
}