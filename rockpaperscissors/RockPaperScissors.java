package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {
    
    public enum Shoot {        
        ROCK,
        PAPER,
        SCISSORS;
    }
    
    private Scanner scanner;
    
    public RockPaperScissors(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public boolean winner (Shoot ownShoot, Shoot opponentShoot) {
        
        if ((ownShoot == Shoot.ROCK && opponentShoot == Shoot.SCISSORS) ||
            (ownShoot == Shoot.PAPER && opponentShoot == Shoot.ROCK) ||
            (ownShoot == Shoot.SCISSORS && opponentShoot == Shoot.PAPER)) {
                
            return true;
        }
        
        return false;
    }
    
    public Shoot shoot() {
        Shoot shoot = Shoot.ROCK;
        boolean valid = false;
        
        do {
            try {
                System.out.println("Please input rock, paper or scissors");
                shoot = Shoot.valueOf(scanner.nextLine().toUpperCase());
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        } while (!valid);
        
        return shoot;
    }
}