package org.ocidem.yatchrental;
import java.util.LinkedList;

public class RentalOffice {
	public int ID;
	public String country;
	public String city;
	private LinkedList<Yatch> allYatchs;
	private LinkedList<Yatch> freeYatchs;//Which are not rented
	private LinkedList<Rental> rentals;
	private int lastYatchID = 0;
	
	public RentalOffice(){
		allYatchs = new LinkedList<Yatch>();
		freeYatchs = new LinkedList<Yatch>();
		rentals = new LinkedList<Rental>();
		reloadYatchs();
		rentals.add(new Rental(0, new ClientCredentials("Ömer", "Berke", "5439229543"), new Yatch(0, "ab", "ab", 0, this), 0, 0));
		rentals.add(new Rental(0, new ClientCredentials("Yetkin Bilge", "Çınar", "0000000"), new Yatch(0, "ab", "ab", 0, this), 0, 0));
		rentals.add(new Rental(0, new ClientCredentials("Semih", "Yılmaz", "38596745"), new Yatch(0, "ab", "ab", 0, this), 0, 0));
	}
	
	//Yatch management starts here yatch
	public void addYatch(String model, String color, float price) {
		Yatch yatch = new Yatch(++lastYatchID, model, color, price, this);
		allYatchs.add(yatch);
		freeYatchs.add(yatch);
	}
	
	public void removeYatch(int id) {
		for(Rental rental : rentals) {
			if(rental.yatch.ID == id) {
				System.out.println("The yatch is currently rented. Rental id is: "+rental.ID);
				return;
			}
		}
		Yatch selected = getYatch(id);
		if(selected == null) {
			System.out.println("No yatch found with id: "+id);
		}else {
			allYatchs.remove(selected);
			freeYatchs.remove(selected);
		}
	}
	
	private void reloadYatchs() {
		//After setting up a database load all yatchs.
		//...load all rentals.
		//...load lastYatchID.
		for(Yatch yatch : allYatchs) {//A loop for declaring free yatchs.
			boolean found = false;
			for(Rental rental : rentals) {
				if (rental.yatch.ID == yatch.ID) {
					found = true;
					break;
				}
			}
			if(!found) freeYatchs.add(yatch);
		}
	}
	
	private Yatch getYatch(int id) {
		for(Yatch yatch : allYatchs) {
			if(id == yatch.ID) return yatch;
		}
		return null;
	}
	//Yatch management ends here
	
	public ClientCredentials findClient(String input) {
		input = input.toLowerCase();
		for(Rental rental : rentals) {
			if(rental.customer.name.toLowerCase().contains(input)|| rental.customer.surname.toLowerCase().contains(input) || rental.customer.phoneNumber.toLowerCase().contains(input)) {
				return rental.customer;
			}
		}
		return null;
	}
	
	//auto generated codes below
	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LinkedList<Yatch> getAllYatchs() {
		return allYatchs;
	}

	public void setAllYatchs(LinkedList<Yatch> allYatchs) {
		this.allYatchs = allYatchs;
	}

	public LinkedList<Yatch> getFreeYatchs() {
		return freeYatchs;
	}

	public void setFreeYatchs(LinkedList<Yatch> freeYatchs) {
		this.freeYatchs = freeYatchs;
	}

	public LinkedList<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(LinkedList<Rental> rentals) {
		this.rentals = rentals;
	}
}