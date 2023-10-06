package se;

import java.util.Scanner;

public class IsPrime {

    public static boolean isPrime(int number) {

        if (number == 2) {
            return true;
        } else if (number < 2 || number % 2 == 0) {
            return false;
        } else {

            for (int i = 3; i < Math.sqrt(number); i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
}