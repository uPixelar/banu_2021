package org.ocidem.yatchrental;
public class Rental {
	public int ID;
	public ClientCredentials customer;
	public Yatch yatch;
	public int startDate;
	public int endDate;
	public Rental(int id, ClientCredentials customer, Yatch yatch, int startDate, int endDate) {
		this.ID = id;
		this.customer = customer;
		this.yatch = yatch;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
