import java.util.Scanner;

public class CheckIfNumberIsEvenOrOdd {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input a number:");
        int number = scanner.nextInt();
        
        /*
        * Sets evenOrOdd to 0 if number is odd or 1 if number is evenOrOdd
        * Because number % 2 does the reverse of this, 1 is added to number
        */
        int evenOrOdd = (number + 1) % 2;        
        System.out.println(evenOrOdd);
    }
}