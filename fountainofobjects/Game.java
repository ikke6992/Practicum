package fountainofobjects;

import myenums.ConsoleColor;
import myexceptions.InvalidMoveException;

public class Game {

    private Room[][] grid;
    private boolean activated;
    public boolean ended;
    
    private final int LENGTH;
    private static final int MINLENGTH = 4;
    
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
    
    public Game(int length) {
        LENGTH = Math.max(length, 4);
        grid = new Room[LENGTH][LENGTH];
        
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                grid[i][j] = new EmptyRoom();
            }
        }
        
        grid[0][0] = new CavernEntranceRoom();
        
        int i;
        int j;
        do {
            i = (int)(Math.random()*LENGTH);
            j = (int)(Math.random()*LENGTH);
        } while (i == 0 && j == 0);
        grid[i][j] = new FountainRoom();
        
        int pitrooms = (LENGTH * LENGTH) / (MINLENGTH * MINLENGTH);
        int current = 0;
        do {
            int k;
            int l;
            do {
                k = (int)(Math.random()*LENGTH);
                l = (int)(Math.random()*LENGTH);
            } while ((k == 0 && l == 0) || (k == i && l == j));
            
            if (!(grid[k][l] instanceof PitRoom)) {
                grid[k][l] = new PitRoom();
                current++;
            }
        } while (current < pitrooms);
        
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
        if (grid[row][column] instanceof PitRoom) {
            end();
        }
    }
    
    public void enableFountain() {
        if (grid[row][column] instanceof FountainRoom) {
            ((FountainRoom) grid[row][column]).activate();
            activated = true;
        }
    }
    
    public boolean sensedraft() {
        for (int i = Math.max(row-1, 0); i <= Math.min(row+1, LENGTH-1); i++) {
            for (int j = Math.max(column-1, 0); j <= Math.min(column+1, LENGTH-1); j++) {
                if (grid[i][j] instanceof PitRoom) {
                    return true;
                }
            }
        }
        return false;
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
        if (grid[row][column] instanceof SpecialRoom) {
            state += "\n" + ((SpecialRoom) grid[row][column]).getSense();
        }
        
        if (sensedraft() && !(grid[row][column] instanceof PitRoom)) {
            state += "\nYou feel a draft. There is a pit in a nearby room.";
        }
        return state;
        
    }
}