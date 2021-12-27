package org.ocidem.yatchrental;
public class Yatch {
	public int ID;
	public String model;
	public String color;
	public float price;
	public RentalOffice office;
	
	public Yatch(int id, String model, String color, float price, RentalOffice office) {
		this.ID = id;
		this.model = model;
		this.color = color;
		this.price = price;
		this.office = office;
	}	
}
