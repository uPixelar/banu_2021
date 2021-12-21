import java.util.Scanner;

public class YatchRental {
	public static Scanner scanner;
	
	private static void Init() {
		System.out.print("Which type of user are you?\n1) Customer\n2) Agent\n: ");
		String input = scanner.nextLine();
		int selection;
		try {
			selection = Integer.parseInt(input, 10);
			if(selection != 1 && selection != 2) {
				System.out.println("(ERROR) Please enter an integer in range [1,2]");
				Init();
			}else {
				switch(selection) {
				case 1:{
					System.out.println("Initializing for customer.");
					customerInit();
					break;
				}
				
				case 2:{
					System.out.println("Initializing for agent.");
					agentInit();
					break;
				}
				}
			}
		}catch(NumberFormatException e) {
			System.out.println("(ERROR) Please enter an integer!");
			Init();
		}
	}
	
	private static void customerInit() {
		
	}
	
	private static void agentInit() {
		
	}
	
	public static void main(String[] args) {//setup
		scanner = new Scanner(System.in);
		
		Init();
	}
}
