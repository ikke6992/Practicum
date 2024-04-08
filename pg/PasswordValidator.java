package pg;

import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidator {
    
    private final Pattern PASSWORD_PATTERN;
    
    public PasswordValidator(String rules) {
        PASSWORD_PATTERN = Pattern.compile(rules);
    }
    
    public boolean isValid(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        PasswordValidator validator = new PasswordValidator("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.*T)(?!.*&).{6,13}$");
        
        while(true) {
            System.out.print("Enter password to validate: ");
            String password = scanner.nextLine();
            
            System.out.printf("Your password is %svalid.\n", validator.isValid(password) ? "" : "in");
        }
            
    }
}