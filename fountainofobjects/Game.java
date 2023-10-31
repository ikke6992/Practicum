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
            int x = (int)(Math.random()*LENGTH);
            int y = (int)(Math.random()*LENGTH);
            
            if (!(grid[x][y] instanceof SpecialRoom)) {
                grid[x][y] = new PitRoom();
                current++;
            }
        } while (current < pitrooms);
        
        int maelstromrooms = LENGTH / MINLENGTH;
        current = 0;
        do {
            int x = (int)(Math.random()*LENGTH);
            int y = (int)(Math.random()*LENGTH);
            
            if (!(grid[x][y] instanceof SpecialRoom)) {
                grid[x][y] = new MaelstromRoom();
                current++;
            }
        } while (current < maelstromrooms);
        
        int amarokrooms = (LENGTH-2)/2;
        current = 0;
        do {
            int x = (int)(Math.random()*LENGTH);
            int y = (int)(Math.random()*LENGTH);
            
            if (!(grid[x][y] instanceof SpecialRoom)) {
                grid[x][y] = new AmarokRoom();
                current++;
            }
        } while (current < amarokrooms);
        
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
        
        while (grid[row][column] instanceof MaelstromRoom) {
            System.out.println(((SpecialRoom) grid[row][column]).getSense());
            grid[row][column] = new EmptyRoom();
            int i = (row + 1) % LENGTH;
            int j = (column + LENGTH - 2) % LENGTH;
            while (grid[i][j] instanceof SpecialRoom) {
                i = (row + 1) % LENGTH;
                j = (column + LENGTH - 2) % LENGTH;
            }
            grid[i][j] = new MaelstromRoom();
            row = (row + LENGTH - 1) % LENGTH;
            column = (column + 2) % LENGTH;
        }
        
        if (grid[row][column] instanceof PitRoom || grid[row][column] instanceof AmarokRoom) {
            end();
        }
    }
    
    public void enableFountain() {
        if (grid[row][column] instanceof FountainRoom) {
            ((FountainRoom) grid[row][column]).activate();
            activated = true;
        }
    }
    
    public boolean senseDraft() {
        for (int i = Math.max(row-1, 0); i <= Math.min(row+1, LENGTH-1); i++) {
            for (int j = Math.max(column-1, 0); j <= Math.min(column+1, LENGTH-1); j++) {
                if (grid[i][j] instanceof PitRoom) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean senseGrowl() {
        for (int i = Math.max(row-1, 0); i <= Math.min(row+1, LENGTH-1); i++) {
            for (int j = Math.max(column-1, 0); j <= Math.min(column+1, LENGTH-1); j++) {
                if (grid[i][j] instanceof MaelstromRoom) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean senseStench() {
        for (int i = Math.max(row-1, 0); i <= Math.min(row+1, LENGTH-1); i++) {
            for (int j = Math.max(column-1, 0); j <= Math.min(column+1, LENGTH-1); j++) {
                if (grid[i][j] instanceof AmarokRoom) {
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
        if (!hasEnded()) {
            if (senseDraft() && !(grid[row][column] instanceof PitRoom)) {
                state += "\nYou feel a draft. There is a pit in a nearby room.";
            }
            if (senseGrowl() && !(grid[row][column] instanceof MaelstromRoom)) {
                state += "\nYou hear the growling and groaning of a maelstrom nearby.";
            }
            if (senseStench() && !(grid[row][column] instanceof AmarokRoom)) {
                state += "\nYou can smell the rotten stench of an amarok in a nearby room.";
            }
        }
        return state;
        
    }
}