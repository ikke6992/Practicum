package indexbasedlists;

import java.util.function.Predicate;

public class MyIntList {
    
    private int[] array;
    private int next;
    private int length;
    private static final int MIN_LENGTH = 16;
    private static final int MAX_LENGTH = 256;
    
    public MyIntList() {
        length = MIN_LENGTH;
        array = new int[length];
        next = 0;
    }
    
    public MyIntList(int length) {
        if (length >= MAX_LENGTH) {
            this.length = MAX_LENGTH;
        } else {
            this.length = MIN_LENGTH;
            while (length > this.length) {
                this.length *= 2;
            }
        }
        array = new int[this.length];
        next = 0;
    }
    
    public MyIntList(int[] array) {
        this();
        for(int i : array) {
            try {
                add(i);
            } catch (MyIntListFullException e) {
                System.out.println(e.getMessage());
                System.out.println("Value " + i + " has not been added");
            }
        }
    }
    
    public void add(int value) throws MyIntListFullException {
        if (next >= length) {
            if (length < MAX_LENGTH) {
                extend();
            } else {
                throw new MyIntListFullException();
            }
        }
        array[next] = value;
        next++;
    }
    
    public int indexAt(int value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    public int getAt(int index) throws MyIndexOutOfBoundsException {
        if (index < next) {
            return array[index];
        } else {
            throw new MyIndexOutOfBoundsException(index);
        }
    }
    
    public void setAt(int index, int value) throws MyIntListFullException {
        if (index < next) {
            array[index] = value;
        } else {
            System.out.printf("%d not in range of MyIntList, %d will be added to index %d\n", 
                index, value, next);
            add(value);
        }
    }
    
    public void insertAt(int index, int value) throws MyIntListFullException {
        if (index < next) {
            if (next >= length) {
                if (length < MAX_LENGTH) {
                   extend();
                } else {
                    throw new MyIntListFullException();
                }
            }
            int[] temp = new int[length];
            for (int i = 0; i < index; i++) {
                temp[i] = array[i];
            }
            temp[index] = value;
            for (int i = index; i < next; i++) {
                temp[i + 1] = array[i];
            }
            array = temp;
            next++;
        } else {
            System.out.printf("%d not in range of MyIntList, %d will be added to index %d\n", 
                index, value, next);
            add(value);
        }
    }
    
    public void removeAt(int index) throws MyIndexOutOfBoundsException {
        if (index < next) {
            next--;
            int[] temp = new int[length];
            for (int i = 0; i < index; i++) {
                temp[i] = array[i];
            }
            for (int i = index; i < next; i++) {
                temp[i] = array[i+1];
            }
            array = temp;
            if (next > MIN_LENGTH / 2 && next < length / 2) {
                reduce();
            }
        } else {
            throw new MyIndexOutOfBoundsException(index);
        }
    }
    
    public void clear() {
        length = MIN_LENGTH;
        array = new int[length];
        next = 0;
    }
    
    public int count() {
        return next;
    }
    
    public boolean contains(int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    
    public MyIntList where(Predicate<Integer> condition) {
        MyIntList conditionalValues = new MyIntList();
        for (int i = 0; i < next; i++) {
            if (condition.test(array[i])) {
                try {
                    conditionalValues.add(array[i]);
                } catch (MyIntListFullException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return conditionalValues;
    }
    
    public int[] toArray() {
        return array;
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < next; i++) {
            result += array[i];
            if (i != next - 1) {
                result += ", ";
            }
        }
        return result;
    }
    
    private void extend() {
        length *= 2;
        int[] temp = new int[length];
        for (int i = 0; i < next; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
    
    private void reduce() {
        length /= 2;
        int[] temp = new int[length];
        for (int i = 0; i < next; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}

class MyIntListFullException extends Exception {
    
    public MyIntListFullException() {
        super("MyIntList is full, not possible to add another value");
    }
}

class MyIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    public MyIndexOutOfBoundsException(int index) {
        super(index + " not in range of MyIntList");
    }
}