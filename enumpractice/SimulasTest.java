package enumpractice;

import java.util.Scanner;

public class SimulasTest {
    
    public enum State {
        OPEN,
        CLOSED,
        LOCKED;
    }
    
    private State state;
    
    public SimulasTest() {
        state = State.LOCKED;
    }
    
    public void unlock() {
        
        if (state.equals(State.LOCKED)) {
            state = State.CLOSED;
        }
    }
    
    public void lock() {
        
        if (state.equals(State.CLOSED)) {
            state = State.LOCKED;
        }
    }
    
    public void open() {
        
        if (state.equals(State.CLOSED)) {
            state = State.OPEN;
        }
    }
    
    public void close() {
        
        if (state.equals(State.OPEN)) {
            state = state.CLOSED;
        }
    }
    
    public String getState() {
        return state.toString();
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        SimulasTest chest = new SimulasTest();
        
        while(true) {
            System.out.printf("The chest is %s. What do you want to do? ", 
                chest.getState());
            
            String input = scanner.nextLine();
            if (input.equals("unlock")) {
                chest.unlock();
            } else if (input.equals("lock")) {
                chest.lock();
            } else if (input.equals("open")) {
                chest.open();
            } else if (input.equals("close")) {
                chest.close();
            } else if (input.equals("break")) {
                break;
            }
        }
    }
    
    
}