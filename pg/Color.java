package pg;

public class Color {
    
    private static final int MIN_COLOR = 0;
    private static final int MAX_COLOR = 255;
    
    private final int red;
    private final int green;
    private final int blue;
    
    public static final Color WHITE = new Color(MAX_COLOR, MAX_COLOR, MAX_COLOR);
    public static final Color BLACK = new Color(MIN_COLOR, MIN_COLOR, MIN_COLOR);
    public static final Color RED = new Color(MAX_COLOR, MIN_COLOR, MIN_COLOR);
    public static final Color ORANGE = new Color(MAX_COLOR, 165, MIN_COLOR);
    public static final Color YELLOW = new Color(MAX_COLOR, MAX_COLOR, MIN_COLOR);
    public static final Color GREEN = new Color(MIN_COLOR, 128, MIN_COLOR);
    public static final Color BLUE = new Color(MIN_COLOR, MIN_COLOR, MAX_COLOR);
    public static final Color PURPLE = new Color(128, MIN_COLOR, 128);
    
    
    
    public Color() {
        this(MAX_COLOR, MAX_COLOR, MAX_COLOR);
    }
    
    public Color(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }
    
    private int inRange(int value) {
        if (value > MAX_COLOR) {
            return MAX_COLOR;
        } else if (value < MIN_COLOR) {
            return MIN_COLOR;
        }
        return value;        
    }
    
    private void setRed(int red) {
        this.red = inRange(red);
    }
    
    private void setGreen(int green) {
        this.green = inRange(green);
    }
    
    private void setBlue(int blue) {
        this.blue = inRange(blue);
    }
    
    public int getRed() {
        return red;
    }
    
    public int getGreen() {
        return green;
    }
    
    public int getBlue() {
        return blue;
    }
    
    public String toString() {
        return String.format("Red: %d, Green: %d, Blue %d", 
            getRed(), getGreen(), getBlue());
    }
    
    public static void main(String[] args) {
        
        Color color = new Color(100, 100, 100);
        
        System.out.println(color);
        
        System.out.println(WHITE);
        
    }
}