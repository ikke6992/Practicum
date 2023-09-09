import java.util.Scanner;

public class BuyingInventory {
	
	private static final String MY_NAME = "Thomas";
	
	public static String getPrice(int item, String name) {
		
		String price;
		
		double discount = name.equals(MY_NAME) ? 0.5 : 1.0;
		
		switch (item) {
			case 1:
				price = "Rope costs " + (10 * discount) + " gold";
				break;
			case 2:
				price = "Torches cost " + (15 * discount) + " gold";
				break;
			case 3:
				price = "Climbing equipment costs " + (25 * discount) + " gold";
				break;
			case 4:
				price = "Clean Water costs " + discount + " gold";
				break;
			case 5:
				price = "Machete costs " + (20 * discount) + " gold";
				break;
			case 6:
				price = "Canoe costs " + (300 * discount) + " gold";
				break;
			case 7:
				price = "Food Supplies cost " + discount + " gold";
				break;
			default:
				price = "Invalid item identifier";
				break;
		}		
		return price;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input item identifier:\n" + 
			"1: Rope\n2: Torches\n3: Climbing Equipment\n" +
			"4: Clean Water\n5: Machete\n6: Canoe\n7: Food Supplies");
		int item = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		
		System.out.println(getPrice(item, name));
		
		scanner.close();
	}
}