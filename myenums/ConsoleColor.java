package myenums;

public enum ConsoleColor {
    RESET(""),
    BLACK(";30"),
    RED(";31"),
    GREEN(";32"),
    YELLOW(";33"),
    BLUE(";34"),
    MAGENTA(";35"),
    CYAN(";36"),
    WHITE(";37");

    private final String code;

    private ConsoleColor(String code) {
        this.code = String.format("\033[0%sm", code);
    }

    @Override
    public String toString() {
        return code;
    }
    
    public String colorString(String string) {
        return code + string + RESET;
    }
}