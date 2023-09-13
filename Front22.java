import java.util.Scanner;

public class Front22 {
    
    public static String front22(String input) {
        
        int take = Math.min(2, input.length());
        
        String front = input.substring(0, take);
        
        return front + input + front;
    }
    
    public static void main(String[] args) {
        
        System.out.println(front22("kitten"));
        System.out.println(front22("Ha"));
        System.out.println(front22("abc"));
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input text to adapt:");
        String input = scanner.nextLine();
        
        System.out.println(front22(input));
    }
}