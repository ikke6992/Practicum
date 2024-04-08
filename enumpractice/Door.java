package enumpractice;

public class Door {

    
    public enum State {
        OPEN,
        CLOSED,
        LOCKED;
    }
    
    private State state;
    private String code;
    
    public Door() {
        state = State.LOCKED;
        code = "1234";
    }
    
    public String unlock(String code) {
        
        if (code.equals(this.code)) {
            if (state == State.LOCKED) {
                state = State.CLOSED;
                return "The door has been unlocked";
            }
            return "The door cannot be unlocked when it is " + getState();
        }
        return "The entered code does not match the passcode";
    }
    
    public String lock() {
        
        if (state == State.CLOSED) {
            state = State.LOCKED;
            return "The door has been locked";
        }
        return "The door cannot be locked when it is " + getState();
    }
    
    public String open() {
        
        if (state == State.CLOSED) {
            state = State.OPEN;
            return "The door is now open";
        }
        return "The door cannot be opened when it is" + getState();
    }
    
    public String close() {
        
        if (state == State.OPEN) {
            state = state.CLOSED;
            return "The door is now closed";
        }
        return "The door cannot be closed when it is" + getState();
    }
    
    public String changeCode(String oldCode, String newCode) {
        if (oldCode.equals(code)) {
            if (newCode.matches("[0-9]+")) {
                code = newCode;
                return "The code has been changed";
            }
            return "The new code needs to consists of numbers only";
        }
        return "The entered code does not match the passcode";
    }
    
    public String getState() {
        return state.toString();
    }
    
}