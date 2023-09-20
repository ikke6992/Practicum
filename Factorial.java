import java.util.Scanner;
import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.println("Please enter an integer greater than zero:");
            number = scanner.nextInt();
        } while (number < 0);


        BigInteger factorial = BigInteger.valueOf(1L);
        for (long i = 2L; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.printf("The factorial of %d is %s", number, factorial.toString());
    }
}