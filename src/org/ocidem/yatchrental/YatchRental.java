package org.ocidem.yatchrental;

import java.text.DecimalFormat;

public class YatchRental {
	private static RentalOffice rentalOffice;
	private static Database database;
	
	private static void Init() {
		//database.addEntry("Yatchs");
		System.out.println("Which type of user are you?\n"
				+ "1) Customer\n"
				+ "2) Agent");
		int selection = Utils.getSelection(2);
		switch(selection) {
		case 1: 
			Client client = new Client();
			client.Init();
			break;
		case 2:
			Agent agent = new Agent();
			agent.Init();
			break;
		}
	}
	
	
	public static RentalOffice getOffice() {
		return rentalOffice;
	}
	
	public static Database getDatabase() {
		return database;
	}
	
	private static void Setup() {
		rentalOffice = new RentalOffice(0, "Turkey", "Balıkesir");
		database = new Database("db");
	}
	
	public static void main(String[] args) {//entrance of app
		Setup();
		Init();
	}
}