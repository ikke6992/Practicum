import java.util.Scanner;

public class ManticoreHunting {
    
    private Scanner input;
    
    private int cityLives;
    private final int CITY_HITPOINTS;
    
    private int manticoreLives;
    private final int MANTICORE_HITPOINTS;
    
    private int location;
    
    private int round;
    
    private final int FIRE;
    private final int ELECTRIC;
    private final int ELECTRIC_FIRE;
    
    private final int NO_EFFECT;
    private final int ONE_EFFECT;
    private final int DOUBLE_EFFECT;
    
    /*
     * Creates an instance of ManticoreHunting with default values for hitpoints and damage modifiers
     */
    public ManticoreHunting(Scanner input, int location) {
        
        this.input = input;
        
        this.location = location;
        
        CITY_HITPOINTS = 15;
        cityLives = CITY_HITPOINTS;
        MANTICORE_HITPOINTS = 10;
        manticoreLives = MANTICORE_HITPOINTS;
        
        FIRE = 3;
        ELECTRIC = 5;
        ELECTRIC_FIRE = FIRE * ELECTRIC;
        NO_EFFECT = 1;
        ONE_EFFECT = 3;
        DOUBLE_EFFECT = 10;
        
        round = 1;
    }
    
    /*
     * Initializer for ManticoreHunting that can be used to input different values for hitpoints and damage modifiers
     */
    public ManticoreHunting(Scanner input, int location, int cityHitpoints, int manticoreHitpoints, int fire, int electric, 
        int noEffect, int oneEffect, int doubleEffect) {
        
        this.input = input;
        
        this.location = location;
        
        CITY_HITPOINTS = cityHitpoints;
        cityLives = CITY_HITPOINTS;
        MANTICORE_HITPOINTS = manticoreHitpoints;
        manticoreLives = MANTICORE_HITPOINTS;
        
        FIRE = fire;
        ELECTRIC = electric;
        ELECTRIC_FIRE = FIRE * ELECTRIC;
        NO_EFFECT = noEffect;
        ONE_EFFECT = oneEffect;
        DOUBLE_EFFECT = doubleEffect;
        
        round = 1;
    }
    
    /*
     * Runs the game
     */
    public void run() {
        
        do {
            System.out.println("--------------------------------------------------------");
            System.out.printf("STATUS: Round: %d City: %d/%d Manticore %d/%d\n",
                round, cityLives, CITY_HITPOINTS, manticoreLives, MANTICORE_HITPOINTS);
            
            System.out.printf("The cannon is expected to deal %d damage this round.\n", cannonDamage(round));
            
            int range = range();
            
            System.out.println(checkIfHit(range));
            
            manticoreDamage();
            
            round++;
        } while (cityIsAlive() && manticoreIsAlive());
    }
    
    /*
     * Determines the damage the cannon will do given the round
     */
    public int cannonDamage(int round) {
        
        int damage = NO_EFFECT;
        if (round % FIRE == 0 || round % ELECTRIC == 0) {
            damage = ONE_EFFECT;
            if (round % ELECTRIC_FIRE == 0) {
                damage = DOUBLE_EFFECT;
            }
        }
        return damage;
    }
    
    /*
     * Asks the player to input a range for the cannon to shoot.
     * Continuously queries until the player has given a valid range.
     */
    public int range() {
        
        int range = Integer.MIN_VALUE;
        do {
            System.out.print("Enter desired cannon range: ");
            range = TakingANumber.askForNumber(input.nextLine());
        } while (range == Integer.MIN_VALUE);
        
        return range;
            
    }
    
    /*
     * Checks whether the Manticore has been hit by comparing the given location
     * to the location of the Manticore. In case of a hit, reduces manticoreLives
     * by the amount of damage done this round. In case of a miss, informs the
     * player on whether the location was too close or too far away.
     */
    public String checkIfHit(int location) {
        if (location == this.location) {
            manticoreLives -= cannonDamage(round);
            return "That round was a DIRECT HIT!";
        } else if (location > this.location) {
            return "That round OVERSHOT the target!";
        } else {
            return "That round FELL SHORT of the target!";
        }
    }
    
    /*
     * In case the manticore hasn't been destroyed yet, damages the city
     */
    public void manticoreDamage() {
        
        if (manticoreIsAlive()) {
            cityLives--;
        }
    }
    
    /*
     * Checks whether the Manticore is still alive
     */
    public boolean manticoreIsAlive() {
        return manticoreLives > 0;
    }
    
    /*
     * Checks whether the City is still alive
     */
    public boolean cityIsAlive() {
        return cityLives > 0;
    }
    
    
}