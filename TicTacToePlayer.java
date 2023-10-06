public class TicTacToePlayer {
    
    private String naam;
    private char piece;
    
    /**
     * Creates an instance of TicTacToePlayer with the given name and piece.
     */
    public TicTacToePlayer(String naam, char piece) {
        this.naam = naam;
        setPiece(piece);
    }
    
    /**
     * Returns the character that is not the value of the player's piece.
     */
    public char otherPiece() {
        if (piece == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }
    
    /**
     * Sets piece to the given character. The character needs to be 'X' or 'O'.
     */
    public void setPiece(char piece) {
        if (piece == 'X' || piece == 'O') {
            this.piece = piece;
        }
    }
    
    /**
     * Gets this player's piece.
     */
    public char getPiece() {
        return piece;
    }
    
    /**
     * Gets this player's name.
     */
    public String getNaam() {
        return naam;
    }
}