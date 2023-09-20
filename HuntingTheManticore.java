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
        
        /*
        do {
            System.out.println("--------------------------------------------------------");
            System.out.printf("STATUS: Round: %d City: %d/%d Manticore %d/%d\n",
                round, cityLives, CITY_HITPOINTS, manticoreLives, MANTICORE_HITPOINTS);
            
            //Determines the damage done this round based on whether there is a status effect
            int damage = REGULAR;
            if (round % FIRE == 0 || round % ELECTRIC == 0) {
                damage = ONE_EFFECT;
                if (round % ELECTRIC_FIRE == 0) {
                    damage = DOUBLE_EFFECT;
                }
            }
            System.out.printf("The cannon is expected to deal %d damage this round.\n", damage);
            
            /*
             * Asks the second player the location to hit with the cannon
             * until the player has input a valid number
             
            int range = Integer.MIN_VALUE;
            do {
                System.out.print("Enter desired cannon range: ");
                range = TakingANumber.askForNumber(scanner.nextLine());
            } while (range == Integer.MIN_VALUE);
            
            // Checks whether the cannon has hit the Manticore
            if (range == distance) {
                manticoreLives -= damage;
                System.out.println("That round was a DIRECT HIT!");
            } else if (range > distance) {
                System.out.println("That round OVERSHOT the target.");
            } else {
                System.out.println("That round FELL SHORT of the target");
            }
            
            // The Manticore attacks the city if it's not yet destroyed
            if (manticoreLives > 0) {
                cityLives--;
            }
            
            //Next round
            round++;
            
        } while (cityLives > 0 && manticoreLives > 0);
        */
        
        
        // Determines who has won the game
        if (!hunting.cityIsAlive()) {
            System.out.println("The City of Consolas has been destroyed!");
        } else {
            System.out.println("The Manticore has been destroyed! The City of Consolas has been saved!");
        }
        
    }
}