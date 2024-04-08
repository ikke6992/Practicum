package fountainofobjects;

import java.time.Duration;
import java.time.LocalDateTime;
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
        
        LocalDateTime start = LocalDateTime.now();
        System.out.println(ConsoleColor.MAGENTA.colorString("You enter the Cavern of Objects, " +
        "a maze of rooms filled with dangerous pits in search of the Fountain of Objects.\n" +
        "Light is visible only in the entrance, and no other light is seen anywhere in the caverns.\n" +
        "You must navigate the Caverns with your other senses.\n" +
        "Find the Fountain of Objects, activate it, and return to the entrance.\n" +
        "Look out for pits. You will feel a breeze if a pit is in an adjacent room. If you enter a room " +
        "with a pit, you will die.\n" +
        "Maelstroms are violent forces of sentient wind. Entering a room with one could transport you " +
        "to any other location in the caverns.\nYou will be able to hear their growling and groaning in nearby rooms.\n" +
        "Amaroks roam the caverns. Encountering one is certain death, but you can smell their rotten stench in nearby rooms.\n" +
        "You carry with you a bow and a quiver of arrows. You can use them to shoot monsters in the caverns but be warned:\n" +
        "you have a limited supply.\n"));
        
        printCommandList();
        System.out.println("\n");
        
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
                    case "shoot north" -> game.shoot(Direction.NORTH);
                    case "shoot east" -> game.shoot(Direction.EAST);
                    case "shoot south" -> game.shoot(Direction.SOUTH);
                    case "shoot west" -> game.shoot(Direction.WEST);
                    case "enable fountain" -> game.enableFountain();
                    case "help" -> printCommandList();
                    case "exit" -> game.end();
                    default -> System.out.println(ConsoleColor.RED.colorString("Invalid command"));
                }
            } catch (InvalidMoveException e) {
                System.out.println(ConsoleColor.RED.colorString(e.getMessage()));
            }
            
            System.out.println("-".repeat(82));
            
        } while (!game.hasEnded());
        LocalDateTime end = LocalDateTime.now();
        long time = Duration.between(start, end).toSeconds();
        
        
        System.out.println(game.getState());
        if (game.hasWon()) {
            System.out.println(ConsoleColor.MAGENTA.colorString("The Fountain of Objects has been reactivated, " + 
                "and you have escaped with your life in " + time + " seconds!\nYou win!"));
        } else {
            System.out.println(ConsoleColor.RED.colorString("You lasted " + time + " seconds."));
        }
    }
    
    public static void printCommandList() {
        System.out.println(ConsoleColor.GREEN.colorString("You can move in any cardinal direction " +
            "with the following commands:\n(move north|move east|move south|move west)\n" +
            "If you have arrows remaining, you can shoot an arrow in any cardinal direction " +
            "with the following commands:\n(shoot north|shoot east|shoot south|shoot west)\n" +
            "If you're in the fountain location you can enable it with the following command: " +
            "(enable fountain)\nOther available commands are (help|exit), help gets you a reminder " +
            "of the list of possible commands\nand exit lets you exit the game without completing it."));       
    }
    
}