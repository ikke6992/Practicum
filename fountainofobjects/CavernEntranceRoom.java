package fountainofobjects;

import myenums.ConsoleColor;

public class CavernEntranceRoom extends SpecialRoom {
    
    public CavernEntranceRoom() {
        color = ConsoleColor.YELLOW;
        sense = "You see light in this room coming from " +
            "outside the cavern. This is the entrance.";
    }
    
}