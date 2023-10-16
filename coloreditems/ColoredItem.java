package coloreditems;

public class ColoredItem<T> {
    
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

        ConsoleColor(String code) {
            this.code = String.format("\033[0%sm", code);
        }

        @Override
        public String toString() {
            return code;
        }
    }
    
    private T item;
    private ConsoleColor color;
    
    public ColoredItem(T item, ConsoleColor color) {
        this.item = item;
        this.color = color;
    }
    
    public void display() {
        System.out.println(color + "" + item.toString() + "" + ConsoleColor.RESET);
    }
    
    public static void main(String[] args) {
        ColoredItem<Sword> aragorn = new ColoredItem<Sword>(new Sword(), ConsoleColor.BLUE);
        ColoredItem<Bow> legolas = new ColoredItem<Bow>(new Bow(), ConsoleColor.GREEN);
        ColoredItem<Axe> gimli = new ColoredItem<Axe>(new Axe(), ConsoleColor.RED);
        
        aragorn.display();
        legolas.display();
        gimli.display();
    }
}