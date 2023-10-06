import java.util.ArrayList;
import java.util.Collections;

public class Puzzle {
    
    //Integer that indicates the length of the board, which will have LENGTH*LENGTH pieces.
    private static final int LENGTH = 4;
    
    //Integer matrix with the current state of the pieces on the board. (Is board a better name for this variable or is pieces the correct name, as it indicates what is in the matrix?) 
    private int[][] pieces;
    
    //Integer to keep track of the number of moves the player has made.
    private int turnCounter;
    
    /**
     * Creates an instance of Puzzle which randomizes the position of each piece
     * on the board.
     */
    public Puzzle() {
        
        //create a list of pieces. The value 0 will indicate the empty piece
        ArrayList<Integer> list = new ArrayList<Integer>(LENGTH*LENGTH);
        for (int i = 0; i < LENGTH*LENGTH; i++) {
            list.add(i);
        }
        
        //use the list to shuffle the pieces
        Collections.shuffle(list);
        
        //put the pieces in a matrix which indicates their position on the board
        pieces = new int[LENGTH][LENGTH];        
        for (int x = 0; x < LENGTH; x++) {
            for (int y = 0; y < LENGTH; y++) {
                pieces[x][y] = list.get(x * LENGTH + y);
            }
        }   
        
        turnCounter = 0;
        
    }
    
    /**
     * Moves the piece indicated by its x- and y-coordinate to the empty space.
     * If the empty space is not adjacent to the piece, throws an InvalidMoveException.
     */
    public void move(int x, int y) throws InvalidMoveException {
        int temp = pieces[x][y];
        
        if (x > 0 && pieces[x-1][y] == 0) {
            pieces[x][y] = 0;
            pieces[x-1][y] = temp;
        } else if (y > 0 && pieces[x][y-1] == 0) {
            pieces[x][y] = 0;
            pieces[x][y-1] = temp;
        } else if (x < LENGTH-1 && pieces[x+1][y] == 0) {
            pieces[x][y] = 0;
            pieces[x+1][y] = temp;
        } else if (y  < LENGTH-1 && pieces[x][y+1] == 0) {
            pieces[x][y] = 0;
            pieces[x][y+1] = temp;
        } else {
            throw new InvalidMoveException();
        }
        
        turnCounter++;
    }
    
    /**
     * Method which returns the current state of the board in a String-representation.
     */
    public String display() {
        StringBuilder format = new StringBuilder();
        format.append("|---".repeat(LENGTH)+"|");
        for (int x = 0; x < LENGTH; x++) {
            format.append("\n|");
            for (int y = 0; y < LENGTH; y++) {
                format.append(String.format("%3d|", pieces[x][y]));
            }
            format.append("\n"+"|---".repeat(LENGTH)+"|");
        }
                
        
        
        
        return format.toString();
    }
    
    /**
     * Checks whether the puzzle has been solved. The puzzle is solved when its pieces are ordered lowest to highest
     * from left to right, then top to bottom, with the right-bottom piece being empty (value 0).
     */
    public boolean isSolved() {
        for (int x = 0; x < LENGTH; x++) {
            for (int y = 0; y < LENGTH; y++) {
                if (pieces[x][y] != x * LENGTH + y + 1 && !(x == LENGTH-1 && y == LENGTH-1)) {
                    return false;
                }
            }
        }
        return true;
    }
    
}