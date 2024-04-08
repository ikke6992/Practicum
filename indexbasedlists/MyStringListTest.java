package indexbasedlists;

import myexceptions.MyListFullException;
import myexceptions.MyIndexOutOfBoundsException;

public class MyStringListTest {
    
    public static void myStringListTest() {
        
        String[] aapnootmies = new String[]{"aap", "noot", "mies", "wim", "zus", "jet", 
            "teun", "vuur", "gijs", "lam", "kees", "bok", "weide", "does", "hok", "duif", "schaap"};
        
        MyStringList stringList0 = new MyStringList();
        MyStringList stringList1 = new MyStringList(20);
        MyStringList stringList2 = new MyStringList(aapnootmies);
        
        System.out.println("stringList0Test:");
        printinfo(stringList0);
        
        System.out.println("TestAdd: ");
        for(String i : aapnootmies) {
            try {
                stringList0.add(i);
            } catch (MyListFullException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(stringList0);
        
        System.out.println("TestIndexAt: ");
        System.out.println("Index of zus: " + stringList0.indexAt("zus"));
        System.out.println("Index of wiel: " + stringList0.indexAt("wiel"));
        
        System.out.println("TestGetAt: ");
        try {
            System.out.println("Get index 5: " + stringList0.getAt(5));
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Get index 25: " + stringList0.getAt(25));
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try{
            System.out.println("Get index 35: " + stringList0.getAt(35));
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        System.out.println("TestSetAt: ");
        try {
            System.out.println("Set wiel at index 5:");
            stringList0.setAt(5, "wiel");
        } catch (MyListFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Set wiel at index 25:");
            stringList0.setAt(25, "wiel");
        } catch (MyListFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Set wiel at index 35:");
            stringList0.setAt(35, "wiel");
        } catch (MyListFullException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        System.out.println("TestInsertAt: ");
        try {
            System.out.println("Insert neef at index 5:");
            stringList0.insertAt(5, "neef");
        } catch (MyListFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Insert neef at index 25:");
            stringList0.insertAt(25, "neef");
        } catch (MyListFullException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        System.out.println("TestRemoveAt: ");
        try {
            System.out.println("Remove index 10:");
            stringList0.removeAt(10);
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Remove index 40:");
            stringList0.removeAt(40);
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        printinfo(stringList0);
        
        System.out.println("TestWhereHasA: ");
        printinfo(stringList0.where(i -> i.contains("a")));
        
        System.out.println("TestClear: ");
        stringList0.clear();
        printinfo(stringList0);
        
        System.out.println("TestOverflow: ");
        for(int i = 0; i < 260; i++) {
            try {
                stringList0.add("+1");
            } catch (MyListFullException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(stringList0);
        
        System.out.println("TestReduce: ");
        for(int i = 150; i >= 0; i--) {
            try {
                stringList0.removeAt(i);
            } catch (MyIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(stringList0);
        
        System.out.println("TestReduceToMinimumSize: ");
        for(int i = 100; i >= 0; i--) {
            try {
                stringList0.removeAt(i);
            } catch (MyIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        printinfo(stringList0);
        
        System.out.println("stringList1Test:");
        printinfo(stringList1);
        
        System.out.println("stringList2Test:");
        printinfo(stringList2);
    }
    
    public static void printinfo(MyStringList myList) {
        System.out.println(myList);
        System.out.println("Count: " + myList.count());
        System.out.println("Length: " + myList.toArray().length);
        System.out.println("Contains zus: " + myList.contains("zus"));
        System.out.println();
    }
}