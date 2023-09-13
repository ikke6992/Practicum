import java.util.Scanner;

public class TheReplicatorOfDTo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Please enter integer %d:", i);
            numbers[i] = scanner.nextInt();
        }

        int[] copy = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }

        System.out.printf("%-16s%-16s\n", "Original:", "Copy:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%-16d%-16d\n", numbers[i], copy[i]);
        }
    }
}