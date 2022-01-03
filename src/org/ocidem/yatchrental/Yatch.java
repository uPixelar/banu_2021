package org.ocidem.yatchrental;
public class Yatch {
	public int id;
	public String model;
	public String color;
	public float price;
	public int office;
	public boolean isRent;
	
	public Yatch(int id, String model, String color, float price, int office, boolean isRent) {
		super();
		this.id = id;
		this.model = model;
		this.color = color;
		this.price = price;
		this.office = office;
		this.isRent = isRent;
	}
}
