import java.util.Scanner;

public class TheFourSistersAndTheDuckbear {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many eggs have been collected today?");
		int eggs = scanner.nextInt();
		
		int eggsPerGirl = eggs / 4;
		int remainingEggs = eggs % 4;
		
		System.out.println("Each girl will get " + eggsPerGirl +
			" eggs today and their duckbear gets the remaining " + remainingEggs);
	}
}