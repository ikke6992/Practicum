package fountainofobjects;

import myenums.ConsoleColor;

public class PitRoom extends SpecialRoom {
    
    public PitRoom() {
        color = ConsoleColor.RED;
        sense = "You fell into a pit and died.";
    }
    
}