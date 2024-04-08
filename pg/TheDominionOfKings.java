package pg;

import java.util.Scanner;

public class TheDominionOfKings {
    
    private static final int DUCHY_SCORE = 3;
    private static final int PROVINCE_SCORE = 6;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insert number of estates:");
        int estates = scanner.nextInt();
        
        System.out.println("Insert number of duchies:");
        int duchies = scanner.nextInt();
        
        System.out.println("Insert number of provinces:");
        int provinces = scanner.nextInt();
        
        int score = estates + duchies * DUCHY_SCORE + provinces * PROVINCE_SCORE;
        System.out.println("Your point total is " + score);
    }
}