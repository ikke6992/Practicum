import java.util.Scanner;

public class Door {

    
    public enum State {
        OPEN,
        CLOSED,
        LOCKED;
    }
    
    private State state;
    private int code;
    
    public Door() {
        state = State.LOCKED;
        code = 1234;
    }
    
    public void unlock(int code) {
        
        if (code == this.code && state.equals(State.LOCKED)) {
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
    
    public void changeCode(int oldCode, int newCode) {
        if (code == oldCode) {
            code = newCode;
        }
    }
    
    public String getState() {
        return state.toString();
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Door door = new Door();
        
        while(true) {
            System.out.printf("The door is %s. What do you want to do?\n" +
            "OPTIONS: unlock, lock, open, close, change, break. ", door.getState());
            
            String input = scanner.nextLine();
            if (input.equals("unlock")) {
                System.out.print("Enter passcode: ");
                int code = scanner.nextInt();
                door.unlock(code);
                scanner.nextLine();
            } else if (input.equals("lock")) {
                door.lock();
            } else if (input.equals("open")) {
                door.open();
            } else if (input.equals("close")) {
                door.close();
            } else if (input.equals("change")) {
                System.out.print("Enter current passcode: ");
                int oldCode = scanner.nextInt();
                System.out.print("Enter new passcode: ");
                int newCode = scanner.nextInt();
                door.changeCode(oldCode, newCode);
                scanner.nextLine();
            } else if (input.equals("break")) {
                break;
            }
        }
    }
    
}