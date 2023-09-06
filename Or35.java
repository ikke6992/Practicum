import java.util.Scanner;

public class Or35 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number:");
        int num = scanner.nextInt();
		
		boolean multiple = (num % 3 == 0 || num % 5 == 0);
		System.out.println("It's " + multiple + " that " + num +
			" is a multiple of 3 or 5");
	}
}