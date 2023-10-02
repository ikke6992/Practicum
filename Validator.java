import java.util.Scanner;

public class Validator {
    
    private static final int MIN_SIZE = 6;
    private static final int MAX_SIZE = 13;
    
    public static boolean validate(String password) {
        
        if (password.length() < MIN_SIZE || password.length() > MAX_SIZE) {
            return false;
        }
        boolean uppercase = false;
        boolean lowercase = false;
        boolean number = false;
        
        for (char letter : password.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                uppercase = true;
            } else if (Character.isLowerCase(letter)) {
                lowercase = true;
            } else if (Character.isDigit(letter)) {
                number = true;
            }
            
            if (letter == 'T' || letter == '&') {
               return false; 
            }
        }
        
        return uppercase && lowercase && number;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter password to validate: ");
        String password = scanner.nextLine();
        
        System.out.printf("Your password is %svalid.", validate(password) ? "" : "in");
        
    }
}