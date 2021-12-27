package org.ocidem.yatchrental;
public class Client {
	public void viewYatchs() {
		YatchRental.getOffice().getFreeYatchs();
	}
	
	public void Init() {
		System.out.println("Hello customer, please select an option\n"
				+ "1) View yachts(After viewing the yachts, you will be asked if you want to rent them)");
		int selection = Utils.getSelection(1);
		switch(selection) {
		case 1:
			viewYatchs();
			break;
		}	
	}
}