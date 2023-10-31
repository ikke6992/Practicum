package fountainofobjects;

import myenums.ConsoleColor;

public class FountainRoom extends SpecialRoom {
    
    public FountainRoom() {
        color = ConsoleColor.BLUE;
        sense = "You hear water dripping in this room." +
            "The Fountain of Objects is here!";
    }
    
    public void activate() {
        sense = "You hear the rushing waters from the Fountain of " +
            "Objects. It has been reactivated!";
    }
    
}