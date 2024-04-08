package fountainofobjects;

import myenums.ConsoleColor;

public class AmarokRoom extends SpecialRoom {
    
    public AmarokRoom() {
        color = ConsoleColor.RED;
        sense = "You were killed by an amarok.";
    }
    
}