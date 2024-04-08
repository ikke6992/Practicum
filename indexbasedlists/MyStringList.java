package indexbasedlists;

import java.util.function.Predicate;
import myexceptions.MyListFullException;
import myexceptions.MyIndexOutOfBoundsException;

public class MyStringList {
    
    private String[] array;
    private int next;
    private int length;
    private static final int MIN_LENGTH = 16;
    private static final int MAX_LENGTH = 256;
    
    public MyStringList() {
        length = MIN_LENGTH;
        array = new String[length];
        next = 0;
    }
    
    public MyStringList(int length) {
        if (length >= MAX_LENGTH) {
            this.length = MAX_LENGTH;
        } else {
            this.length = MIN_LENGTH;
            while (length > this.length) {
                this.length *= 2;
            }
        }
        array = new String[this.length];
        next = 0;
    }
    
    public MyStringList(String[] array) {
        this();
        for(String i : array) {
            try {
                add(i);
            } catch (MyListFullException e) {
                System.out.println(e.getMessage());
                System.out.println("Value " + i + " has not been added");
            }
        }
    }
    
    public void add(String value) throws MyListFullException {
        if (next >= length) {
            if (length < MAX_LENGTH) {
                extend();
            } else {
                throw new MyListFullException("MyStringList is full, not possible to add another value");
            }
        }
        array[next] = value;
        next++;
    }
    
    public int indexAt(String value) {
        for (int i = 0; i < next; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    public String getAt(int index) throws MyIndexOutOfBoundsException {
        if (index < next) {
            return array[index];
        } else {
            throw new MyIndexOutOfBoundsException(index);
        }
    }
    
    public void setAt(int index, String value) throws MyListFullException {
        if (index < next) {
            array[index] = value;
        } else {
            System.out.printf("%d not in range of MyStringList, %s will be added to index %d\n", 
                index, value, next);
            add(value);
        }
    }
    
    public void insertAt(int index, String value) throws MyListFullException {
        if (index < next) {
            if (next >= length) {
                if (length < MAX_LENGTH) {
                   extend();
                } else {
                    throw new MyListFullException("MyStringList is full, not possible to add another value");
                }
            }
            String[] temp = new String[length];
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
            System.out.printf("%d not in range of MyStringList, %s will be added to index %d\n", 
                index, value, next);
            add(value);
        }
    }
    
    public void removeAt(int index) throws MyIndexOutOfBoundsException {
        if (index < next) {
            next--;
            String[] temp = new String[length];
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
        array = new String[length];
        next = 0;
    }
    
    public int count() {
        return next;
    }
    
    public boolean contains(String value) {
        for (int i = 0; i < next; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public MyStringList where(Predicate<String> condition) {
        MyStringList conditionalValues = new MyStringList();
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
    
    public String[] toArray() {
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
        String[] temp = new String[length];
        for (int i = 0; i < next; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
    
    private void reduce() {
        length /= 2;
        String[] temp = new String[length];
        for (int i = 0; i < next; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}