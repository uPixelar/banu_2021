package org.ocidem.yatchrental;

public class YatchRental {
	private static RentalOffice rentalOffice;
	
	private static void Init() {
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
	
	private static void Setup() {
		rentalOffice = new RentalOffice();
	}
	
	public static void main(String[] args) {//entrance of app
		String[] list = "Let's  test it  together".split("\s+");
		for(String i:list)
			System.out.println(i);
		//Setup();
		//Init();
	}
}