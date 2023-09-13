import java.util.Scanner;

public class ConsolasAndTelim {
    
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bread is ready.\nWho is the bread for?");
        System.out.println("Noted: " + scanner.nextLine() + " got bread.");
    }
}