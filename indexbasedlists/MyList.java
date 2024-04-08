package indexbasedlists;

import java.util.function.Predicate;
import myexceptions.MyListFullException;
import myexceptions.MyIndexOutOfBoundsException;

public class MyList<T> {
    
    private T[] array;
    private int next;
    private int length;
    private static final int MIN_LENGTH = 16;
    private static final int MAX_LENGTH = 256;
    
    public MyList() {
        length = MIN_LENGTH;
        array = new T[length];
        next = 0;
    }
    
    public MyList(int length) {
        if (length >= MAX_LENGTH) {
            this.length = MAX_LENGTH;
        } else {
            this.length = MIN_LENGTH;
            while (length > this.length) {
                this.length *= 2;
            }
        }
        array = new T[this.length];
        next = 0;
    }
    
    public MyList(T[] array) {
        this();
        for(T i : array) {
            try {
                add(i);
            } catch (MyListFullException e) {
                System.out.println(e.getMessage());
                System.out.println("Value " + i.toString() + " has not been added");
            }
        }
    }
    
    public void add(T value) throws MyListFullException {
        if (next >= length) {
            if (length < MAX_LENGTH) {
                extend();
            } else {
                throw new MyListFullException("MyList is full, not possible to add another value");
            }
        }
        array[next] = value;
        next++;
    }
    
    public int indexAt(T value) {
        for (int i = 0; i < next; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    public T getAt(int index) throws MyIndexOutOfBoundsException {
        if (index < next) {
            return array[index];
        } else {
            throw new MyIndexOutOfBoundsException(index);
        }
    }
    
    public void setAt(int index, T value) throws MyListFullException {
        if (index < next) {
            array[index] = value;
        } else {
            System.out.printf("%d not in range of MyList, %s will be added to index %d\n", 
                index, value.toString(), next);
            add(value);
        }
    }
    
    public void insertAt(int index, T value) throws MyListFullException {
        if (index < next) {
            if (next >= length) {
                if (length < MAX_LENGTH) {
                   extend();
                } else {
                    throw new MyListFullException("MyList is full, not possible to add another value");
                }
            }
            T[] temp = new T[length];
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
            System.out.printf("%d not in range of MyList, %s will be added to index %d\n", 
                index, value.toString(), next);
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
        array = new T[length];
        next = 0;
    }
    
    public int count() {
        return next;
    }
    
    public boolean contains(T value) {
        for (int i = 0; i < next; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public MyList where(Predicate<T> condition) {
        MyList conditionalValues = new MyList();
        for (int i = 0; i < next; i++) {
            if (condition.test(array[i])) {
                try {
                    conditionalValues.add(array[i]);
                } catch (MyListFullException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return conditionalValues;
    }
    
    public T[] toArray() {
        return array;
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < next; i++) {
            result += array[i].toString();
            if (i != next - 1) {
                result += ", ";
            }
        }
        return result;
    }
    
    private void extend() {
        length *= 2;
        T[] temp = new T[length];
        for (int i = 0; i < next; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
    
    private void reduce() {
        length /= 2;
        T[] temp = new T[length];
        for (int i = 0; i < next; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
    
}