package pg;

import java.util.Scanner;

public class Watchtower {
    
    public static String alarm(int x, int y) {
        String result = "The enemy is ";
        
        if (x == 0 && y == 0) {
            result += "here!";
        } else {
            result += "to the ";
            
            if (y > 0) {
                result += "north";
            } else if (y < 0) {
                result += "south";
            }
            
            if (x > 0) {
                result += "east";
            } else if (x < 0) {
                result += "west";
            }
            
            result += "!";            
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Where is the enemy?\nx: ");
        int x = scanner.nextInt();
        
        System.out.print("y: ");
        int y = scanner.nextInt();
        
        System.out.println(alarm(x, y));
    }
}