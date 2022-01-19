package org.ocidem.yatchrental;

import java.util.ArrayList;

public class Client {
	public void viewYatchs() {
		ArrayList<Yatch> yatchs = YatchRental.getOffice().getFreeYatchs();
		int size = yatchs.size();
		for(int i=0; i<size; i++) {
			Yatch yatch = yatchs.get(i);
			System.out.println(String.format("%s) %s : %s", i+1, yatch.model, yatch.price));
		}
		int selection = Utils.getSelection(size);
		Yatch yatch = yatchs.get(selection-1);
		System.out.println(String.format("%s, %s, %s, %s", yatch.id, yatch.model, yatch.color, yatch.price));
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