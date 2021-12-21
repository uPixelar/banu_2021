public class Client {
	private ClientCredentials credentials;
	
	public Client(String name, String surname, String number){
		this.credentials = new ClientCredentials(name, surname, number);
	}
	
	
	public Yatch[] viewYatchs() {
		return null;
		//There will be a connection between Rental Office's database and the client will receive an array of Yatchs.
	}
	
	public void rentYatch(int yatchid, PaymentCredentials pCredentials) {
		
	}
	
	public void enterSMSCode(String number, String code) {
		
	}
	
}