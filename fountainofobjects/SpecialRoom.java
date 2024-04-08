package fountainofobjects;

import myenums.ConsoleColor;

public abstract class SpecialRoom implements Room {
    
    protected ConsoleColor color;
    protected String sense;

    public String getSense() {
        return color.colorString(sense);
    }
    
}