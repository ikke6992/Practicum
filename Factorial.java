import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.println("Please enter an integer greater than zero:");
            number = scanner.nextInt();
        } while (number < 0);


        long factorial = 1 l;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        System.out.printf("The factorial of %d is %d", number, factorial);
    }
}