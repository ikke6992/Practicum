import java.util.Scanner;

public class ThePrototype {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int number;
        
        do {
            System.out.println("Pilot, enter a number between 0 and 100:");
            number = scanner.nextInt();
        } while (number > 100 || number < 0);
        
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        
        boolean correct = false;
        int iterator = 1;
        System.out.println("Hunter, guess the mumber.");
        
        while (!correct) {
            System.out.println("What is your next guess?");
            
            int guess = scanner.nextInt();
            
            if (guess == number) {
                System.out.println("You guessed the number!");
                System.out.println("The amount of guesses it took you to get it was: " + iterator);
                correct = true;
            } else if (guess < number) {
                if (guess < 0) {
                    System.out.println("The number cannot be below 0.");
                } else {
                    System.out.println(guess + " is too low.");
                }
            } else if (guess > number) {
                if (guess > 100) {
                    System.out.println("The number cannot be above 100.");
                } else {
                    System.out.println(guess + " is too high.");
                }
            }
            
            iterator++;
        }
    }
}