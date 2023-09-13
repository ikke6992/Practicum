import java.util.Scanner;
import java.awt.Toolkit;

public class TheDefenseOfConsolas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Target Row?");
        int row = scanner.nextInt();

        System.out.println("Target Column?");
        int column = scanner.nextInt();        

        System.out.println("Deploy to:\n\u001B[31m(" + row + ", " + (column - 1) +
            ")\n\u001B[32m(" + (row - 1) + ", " + column + ")\n\u001B[33m(" + row + ", " +
            (column + 1) + ")\n\u001B[34m(" + (row + 1) + ", " + column + ")\u001B[0m");

        Toolkit.getDefaultToolkit().beep();
    }
}