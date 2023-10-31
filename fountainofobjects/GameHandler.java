package fountainofobjects;

import java.util.Scanner;
import myenums.ConsoleColor;
import myexceptions.InvalidMoveException;

public class GameHandler {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        
        System.out.print("What size should the cavern be? OPTIONS: (small|medium|large) ");
        boolean valid = false;
        
        do {
            String size = in.nextLine();
            
            switch (size) {
                case "small" -> {
                    game = new Game(4);
                    valid = true;
                }
                case "medium" -> {
                    game = new Game(6);
                    valid = true;
                }
                case "large" -> {
                    game = new Game(8);
                    valid = true;
                }
                default -> System.out.println(ConsoleColor.RED.colorString("Invalid command"));
            }
        } while (!valid);
        
        System.out.println(ConsoleColor.MAGENTA.colorString("The player moves through the cavern system one room " +
            "at a time to find the Fountain of Objects.\nThey activate it and then return to the entrance room. " +
            "If they do this without falling into a pit, they win the game.\n\nUnnatural darkness pervades the caverns, " +
            "preventing both natural and human-made light.\nThe player must navigate the caverns in the dark, relying " +
            "on their sense of smell\nand hearing to determine what room they are in and what dangers lurk in nearby rooms.\n\n" +
            "The player is in one of the rooms and can move between them by typing commands like the following: \n" +
            "(move north|move south|move east|move west|enable fountain|exit)"));
        
        do {
            System.out.println(game.getState());
            System.out.print("What do you want to do? " + ConsoleColor.CYAN);
            String input = in.nextLine();
            System.out.print(ConsoleColor.RESET);
            
            try {
                switch (input) {
                    case "move north" -> game.move(Direction.NORTH);
                    case "move east" -> game.move(Direction.EAST);
                    case "move south" -> game.move(Direction.SOUTH);
                    case "move west" -> game.move(Direction.WEST);
                    case "enable fountain" -> game.enableFountain();
                    case "exit" -> game.end();
                    default -> System.out.println(ConsoleColor.RED.colorString("Invalid command"));
                }
            } catch (InvalidMoveException e) {
                System.out.println(ConsoleColor.RED.colorString(e.getMessage()));
            }
            
            System.out.println("-".repeat(82));
            
        } while (!game.hasEnded());
        
        
        System.out.println(game.getState());
        if (game.hasWon()) {
            System.out.println(ConsoleColor.MAGENTA.colorString("The Fountain of Objects has been reactivated, " + 
                "and you have escaped with your life!\nYou win!"));
        }
    }
}