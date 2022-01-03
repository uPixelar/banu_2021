package org.ocidem.yatchrental;
public class Rental {
	public int id;
	public String name;
	public String surname;
	public String phoneNumber;
	public int yatch;
	public long startDate;
	public long endDate;
	
	public Rental(int id, String name, String surname, String phoneNumber, int yatch, long startDate, long endDate) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.yatch = yatch;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Yatch getYatch() {
		return YatchRental.getDatabase().getYatch("id", String.valueOf(yatch));
	}
}
