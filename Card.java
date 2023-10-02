public class Card {
    
    private enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW;
    }
    
    private enum Rank {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        DOLLARSIGN,
        PERCENT,
        CIRCUMFLEX,
        AMPERSAND;
    }
    
    private Color color;
    private Rank rank;
    
    public Card(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }
    
    public Color getColor() {
        return color;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public String toString() {
        return String.format("THE %s %s", getColor(), getRank());
    }
    
    public static void main(String[] args) {
        
        for (Color color : Color.values()) {            
            for (Rank rank : Rank.values()) {
                System.out.println(new Card(color, rank));
            }
        }
    }
}