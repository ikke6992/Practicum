package fountainofobjects;

import myenums.ConsoleColor;

public class CavernEntranceRoom implements Room {
    
    private final ConsoleColor yellow = ConsoleColor.YELLOW;
    
    private String sense = yellow.colorString("You see light in this room " +
        "coming from outside the cavern. This is the entrance.");
        
    public String getSense() {
        return sense;
    }
}