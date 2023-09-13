import java.util.Scanner;

public class TheDominionOfKings {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insert number of estates:");
        int estates = scanner.nextInt();
        
        System.out.println("Insert number of duchies:");
        int duchies = scanner.nextInt();
        
        System.out.println("Insert number of provinces:");
        int provinces = scanner.nextInt();
        
        int score = estates + duchies * 3 + provinces * 6;
        System.out.println("Your point total is " + score);
    }
}