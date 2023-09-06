import java.util.Scanner;

public class LastDigit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        int firstNum = scanner.nextInt();

        System.out.println("Enter second number:");
        int secondNum = scanner.nextInt();

        boolean same = (firstNum % 10 == secondNum % 10);
        System.out.println("It's " + same + " that " + firstNum +
            " and " + secondNum + " have the same last digit");

        scanner.close();
    }
}