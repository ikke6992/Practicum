package enumpractice;

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
    
    public boolean isSymbol() {
        return rank == Rank.DOLLARSIGN || rank == Rank.PERCENT ||
            rank == Rank.CIRCUMFLEX || rank == Rank.AMPERSAND;
    }
    
    @Override
    public String toString() {
        return String.format("THE %s %s", getColor(), getRank());
    }
    
    public static void main(String[] args) {
        
        for (Color color : Color.values()) {            
            for (Rank rank : Rank.values()) {
                Card card = new Card(color, rank);
                System.out.println(card + " " + card.isSymbol());
            }
        }
    }
}