package fountainofobjects;

import myenums.ConsoleColor;
import myexceptions.InvalidMoveException;

public class Game {

    private Room[][] grid;
    private boolean activated;
    public boolean ended;
    
    private final int LENGTH;
    
    private int row;
    private int column;
    
    public Game() {
        LENGTH = 4;
        grid = new Room[LENGTH][LENGTH];
        
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                grid[i][j] = new EmptyRoom();
            }
        }
        
        grid[0][0] = new CavernEntranceRoom();
        grid[0][2] = new FountainRoom();
        
        row = 0;
        column = 0;
        
        activated = false;
        ended = false;
    }
    
    public void move(Direction direction) throws InvalidMoveException {
        switch(direction) {
            case NORTH -> {
                if (row > 0) {
                    row--;
                } else {
                    throw new InvalidMoveException();
                }
            }
            case EAST -> {
                if (column < LENGTH-1) {
                    column++;
                } else {
                    throw new InvalidMoveException();
                }
            }
            case SOUTH -> {
                if (row < LENGTH-1) {
                    row++;
                } else {
                    throw new InvalidMoveException();
                }
            }
            case WEST -> {
                if (column > 0) {
                    column--;
                } else {
                    throw new InvalidMoveException();
                }
            }
        }
    }
    
    public void enableFountain() {
        if (grid[row][column] instanceof FountainRoom) {
            ((FountainRoom) grid[row][column]).activate();
            activated = true;
        }
    }
    
    public void end() {
        ended = true;
    }
    
    public boolean hasEnded() {
        return ended || hasWon();
    }
    
    public boolean hasWon() {
        return activated && grid[row][column] instanceof CavernEntranceRoom;
    }
    
    public String getState() {
        String state = String.format("You are in the room at (Row=%d, Column=%d)", row, column);
        if (grid[row][column] instanceof FountainRoom) {
            state += "\n" + ((FountainRoom) grid[row][column]).getSense();
        } else if (grid[row][column] instanceof CavernEntranceRoom) {
            state += "\n" + ((CavernEntranceRoom) grid[row][column]).getSense();
        }
        return state;
        
    }
}