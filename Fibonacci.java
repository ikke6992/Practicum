import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

public class Fibonacci {

	public static List<Integer> fibonacciNumbers(int maximum) {
		
		if (maximum <= 0) {
			throw new IllegalArgumentException("All fibonaccinumbers are bigger than 0");
		} else {
			List<Integer> fibonacciNumbers = new ArrayList<>();
			int nextFib = 1;
			int lastFib = 1;
			fibonacciNumbers.add(lastFib);
			while (nextFib <= maximum) {
				fibonacciNumbers.add(nextFib);
				int temp = lastFib;
				lastFib = nextFib;
				nextFib += temp;
			}
			return fibonacciNumbers;
		}
	}
	
	public static List<Integer> fibonacciNumbersForLoop(int maximum) {
		
		if (maximum <= 0) {
			throw new IllegalArgumentException("All fibonaccinumbers are bigger than 0");
		} else {
			List<Integer> fibonacciNumbers = new ArrayList<>();
			int lastFib = 1;
			int temp = 0;
			fibonacciNumbers.add(lastFib);
			for (int nextFib = 1; nextFib <= maximum; nextFib += temp) {
				fibonacciNumbers.add(nextFib);
				temp = lastFib;
				lastFib = nextFib;
			}
			return fibonacciNumbers;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter maximum:");
		int maximum = scanner.nextInt();
		
		List<Integer> fibonacciNumbers = fibonacciNumbersForLoop(maximum);
		for (int number : fibonacciNumbers) {
			System.out.print(number + " ");
		}
		
		scanner.close();
	}
}