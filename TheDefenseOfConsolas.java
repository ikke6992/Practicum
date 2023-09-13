import java.util.Scanner;
import java.awt.Toolkit;

public class TheDefenseOfConsolas {

    public enum Colour {
        RESET("\033[0m"),
        BLACK("\033[0;30m"),
        RED("\033[0;31m"),
        GREEN("\033[0;32m"),
        YELLOW("\033[0;33m"),
        BLUE("\033[0;34m"),
        MAGENTA("\033[0;35m"),
        CYAN("\033[0;36m"),
        WHITE("\033[0;37m");
        
        private final String code;
        
        Colour(String code) {
            this.code = code;
        }
        
        @Override
        public String toString() {
            return code;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Target Row?");
        int row = scanner.nextInt();

        System.out.println("Target Column?");
        int column = scanner.nextInt();    

        System.out.printf("Deploy to:");
        System.out.printf("%s (%d, %d)", Colour.RED, row, column-1);
        System.out.printf("%s (%d, %d)", Colour.GREEN, row-1, column);
        System.out.printf("%s (%d, %d)", Colour.YELLOW, row, column+1);
        System.out.printf("%s (%d, %d)", Colour.CYAN, row+1, column);
        
        System.out.print(Colour.RESET);

        /*
        System.out.println("Deploy to:\n\u001B[31m(" + row + ", " + (column - 1) +
            ")\n\u001B[32m(" + (row - 1) + ", " + column + ")\n\u001B[33m(" + row + ", " +
            (column + 1) + ")\n\u001B[34m(" + (row + 1) + ", " + column + ")\u001B[0m");
        */

        Toolkit.getDefaultToolkit().beep();
    }
}