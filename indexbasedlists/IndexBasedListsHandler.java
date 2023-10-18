package indexbasedlists;

public class IndexBasedListsHandler {
    
    public static void main(String[] args) {
        
        MyIntList intList0 = new MyIntList();
        MyIntList intList1 = new MyIntList(20);
        MyIntList intList2 = new MyIntList(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
        
        System.out.println("intList0Test:");
        printinfo(intList0);
        
        System.out.println("TestAdd: ");
        for(int i = 0; i < 20; i++) {
            try {
                intList0.add(i);
            } catch (MyIntListFullException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(intList0);
        
        System.out.println("TestIndexAt: ");
        System.out.println("Index of 1: " + intList0.indexAt(1));
        System.out.println("Index of 21: " + intList0.indexAt(21));
        
        System.out.println("TestGetAt: ");
        try {
            System.out.println("Get index 5: " + intList0.getAt(5));
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Get index 25: " + intList0.getAt(25));
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try{
            System.out.println("Get index 35: " + intList0.getAt(35));
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        System.out.println("TestSetAt: ");
        try {
            System.out.println("Set 42 at index 5:");
            intList0.setAt(5, 42);
        } catch (MyIntListFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Set 42 at index 25:");
            intList0.setAt(25, 42);
        } catch (MyIntListFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Set 42 at index 35:");
            intList0.setAt(35, 42);
        } catch (MyIntListFullException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        System.out.println("TestInsertAt: ");
        try {
            System.out.println("Insert 9001 at index 5:");
            intList0.insertAt(5, 9001);
        } catch (MyIntListFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Insert 9001 at index 25:");
            intList0.insertAt(25, 9001);
        } catch (MyIntListFullException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        System.out.println("TestRemoveAt: ");
        try {
            System.out.println("Remove index 10:");
            intList0.removeAt(10);
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Remove index 40:");
            intList0.removeAt(40);
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        printinfo(intList0);
        
        System.out.println("TestWhereEven: ");
        printinfo(intList0.where(i -> i % 2 == 0));
        
        System.out.println("TestClear: ");
        intList0.clear();
        printinfo(intList0);
        
        System.out.println("TestOverflow: ");
        for(int i = 0; i < 260; i++) {
            try {
                intList0.add(i);
            } catch (MyIntListFullException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(intList0);
        
        System.out.println("TestReduce: ");
        for(int i = 150; i >= 0; i--) {
            try {
                intList0.removeAt(i);
            } catch (MyIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(intList0);
        
        System.out.println("TestReduceToMinimumSize: ");
        for(int i = 100; i >= 0; i--) {
            try {
                intList0.removeAt(i);
            } catch (MyIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(intList0);
        
        System.out.println("intList1Test:");
        printinfo(intList1);
        
        System.out.println("intList2Test:");
        printinfo(intList2);
    }
    
    public static void printinfo(MyIntList intList) {
        System.out.println(intList);
        System.out.println("Count: " + intList.count());
        System.out.println("Length: " + intList.toArray().length);
        System.out.println("Contains 1: " + intList.contains(1));
        System.out.println();
    }
        
}