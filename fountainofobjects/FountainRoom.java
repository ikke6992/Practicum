package fountainofobjects;

import myenums.ConsoleColor;

public class FountainRoom implements Room {
    
    private final ConsoleColor blue = ConsoleColor.BLUE;
    
    private String sense = blue.colorString("You hear water dripping in this room." +
        "The Fountain of Objects is here!");
    
    public String getSense() {
        return sense;
    }
    
    public void activate() {
        sense = blue.colorString("You hear the rushing waters from the Fountain of " +
            "Objects. It has been reactivated!");
    }
}