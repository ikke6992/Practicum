import java.util.Scanner;

public class TheDefenseOfConsolas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Target Row?");
        int row = scanner.nextInt();

        System.out.println("Target Column?");
        int column = scanner.nextInt();

        System.out.println("Deploy to:\n(" + row + ", " + (column - 1) +
            ")\n(" + (row - 1) + ", " + column + ")\n(" + row + ", " +
            (column + 1) + ")\n(" + (row + 1) + ", " + column + ")");

        scanner.close();
    }
}