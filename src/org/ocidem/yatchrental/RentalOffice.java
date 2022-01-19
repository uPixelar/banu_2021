package org.ocidem.yatchrental;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentalOffice {
	public int id;
	public String country;
	public String city;
	
	public RentalOffice(int id, String country, String city) {
		this.id = id;
		this.country = country;
		this.city = city;
	}
	
	//Yatch management starts here yatch
	public void addYatch(String model, String color, double price) {
		Map<String, String> values = new HashMap<>();
		values.put("model", model);
		values.put("color", color);
		values.put("price", String.valueOf(price));
		values.put("office", String.valueOf(id));
		YatchRental.getDatabase().addEntry("Yatchs", values);
	}
	
	public void removeYatch(int id) {
		Rental rental = YatchRental.getDatabase().getRental("yatch", String.valueOf(id));
		if(rental != null) {
			System.out.println(String.format("Cannot remove yatch, currently in rent: %s", rental.id));
		}else {
			YatchRental.getDatabase().removeYatch("id", String.valueOf(id));
		}		
	}
	
	public Yatch getYatch(int id) {
		return YatchRental.getDatabase().getYatch("id", String.valueOf(id));
	}
	
	public ArrayList<Yatch> getFreeYatchs() {
		return YatchRental.getDatabase().getFreeYatchs();
	}
	
	public ArrayList<Yatch> getAllYatchs() {
		return YatchRental.getDatabase().getAllYatchs();
	}
	//Yatch management ends here
}