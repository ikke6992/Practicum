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
    
    public void unlock(String code) {
        
        if (code.equals(this.code) && state == State.LOCKED) {
            state = State.CLOSED;
        }
    }
    
    public void lock() {
        
        if (state == State.CLOSED) {
            state = State.LOCKED;
        }
    }
    
    public void open() {
        
        if (state == State.CLOSED) {
            state = State.OPEN;
        }
    }
    
    public void close() {
        
        if (state == State.OPEN) {
            state = state.CLOSED;
        }
    }
    
    public void changeCode(String oldCode, String newCode) {
        if (oldCode.equals(code) && newCode.matches("[0-9]+")) {
            code = newCode;
        }
    }
    
    public String getState() {
        return state.toString();
    }
    
}