public class TicTacToe {
    
    private TicTacToePlayer thisTurn;
    private TicTacToePlayer nextTurn;
    private int turnCounter;

    private char[][] board;
    
    /**
     * Creates an instance of TicTacToe with the two given players and an empty board.
     */
    public TicTacToe(TicTacToePlayer player1, TicTacToePlayer player2) {
        nextTurn = player1;
        thisTurn = player2;
        reset();
    }
    
    /**
     * Displays the current state of the board.
     */
    public String display() {
        String display = "";
        for(int i = 0; i < 3; i++) {
            display += String.format(" %c | %c | %c \n", board[i][0], board[i][1], board[i][2]);
            if (i != 2) {
                display += "---+---+---\n";
            }
        }
        return display;
    }
    
    /**
     * Sets the given position to the given piece. Throws an InvalidMoveException
     * if the given position already has a piece in it.
     */
    public void move(int position, char piece) throws InvalidMoveException {
        if (board[position/3][position%3] != ' ') {
            throw new InvalidMoveException();
        }
        board[position/3][position%3] = piece;
    }
    
    /**
     * Switches the player whose turn it is.
     */
    public TicTacToePlayer next() {
        TicTacToePlayer temp = thisTurn;
        thisTurn = nextTurn;
        nextTurn = temp;
        turnCounter++;
        return thisTurn;
    }
    
    /**
     * Checks whether the given piece has a winning combination. Winning combinations
     * are a full horizontal, vertical or diagonal filled with this piece.
     */
    public boolean winner(char piece) {
        
        //check diagonals
        if ((board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) ||
            (board[2][0] == piece && board[1][1] == piece && board[0][2] == piece)) {
                return true;
        }
        
        //check horizontals and verticals
        for(int i = 0; i < 3; i++) {
            if ((board[i][0] == piece && board[i][1] == piece && board[i][2] == piece) ||
                (board[0][i] == piece && board[1][i] == piece && board[2][i] == piece)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks whether the game is over. The game ends when the player whose turn it is
     * has won or the board is full after 9 turns.
     */
    public boolean gameOver() {
        return winner(thisTurn.getPiece()) || turnCounter == 9;
    }
    
    /**
     * Resets the game by emptying the board and setting the turnCounter to 0.
     */
    public void reset() {
        board = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        turnCounter = 0;
    }
    
}