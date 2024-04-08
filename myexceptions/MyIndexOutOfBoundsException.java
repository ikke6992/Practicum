package myexceptions;

public class MyIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    public MyIndexOutOfBoundsException(int index) {
        super(index + " not in range of MyIntList");
    }
}