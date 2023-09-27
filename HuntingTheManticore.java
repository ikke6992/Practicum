import java.util.Scanner;

public class HuntingTheManticore {
    
    private static final int MIN_DISTANCE = 0;
    private static final int MAX_DISTANCE = 100;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        /*
         * Asks the first player where to deploy the Manticore until the desired distance is within the 
         * range determined by MIN_DISTANCE and MAX_DISTANCE
         */
        int distance = Integer.MIN_VALUE;
        do {
        System.out.print("Player 1, how far away from the city " +
            "do you want to station the Manticore? ");
        distance = TakingANumber.askForNumberInRange(scanner.nextLine(), MIN_DISTANCE, MAX_DISTANCE);
        } while (distance == Integer.MIN_VALUE);
        
        // Clears the screen so the second player can't see the location of the Manticore
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        
        /*
         * Initializes the game. The game will continue as long as both the city 
         * and the Manticore have more than 0 lives left
         */
        ManticoreHunting hunting = new ManticoreHunting(scanner, distance);
        System.out.println("Player 2, it is your turn.");
        
        hunting.run();        
        
        // Determines who has won the game
        if (!hunting.cityIsAlive()) {
            System.out.println("The City of Consolas has been destroyed!");
        } else {
            System.out.println("The Manticore has been destroyed! The City of Consolas has been saved!");
        }
        
    }
}