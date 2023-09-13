import java.util.Scanner;

public class Watchtower {
    
    public static String alarm(int x, int y) {
        String result = "The enemy is ";
        
        if (x == 0 && y == 0) {
            return result += "here!";
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
            
            return result += "!";            
        }
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Where is the enemy?\nx:");
        int x = scanner.nextInt();
        
        System.out.println("y:");
        int y = scanner.nextInt();
        
        System.out.println(alarm(x, y));
    }
}