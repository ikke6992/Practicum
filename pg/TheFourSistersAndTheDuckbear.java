package pg;

import java.util.Scanner;

public class TheFourSistersAndTheDuckbear {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many eggs have been collected today?");
        int eggs = scanner.nextInt();
        
        int eggsPerSister = eggs / 4;
        int remainingEggs = eggs % 4;
        
        System.out.println("Each girl will get " + eggsPerSister +
            " eggs today and their duckbear gets the remaining " + remainingEggs);
    }
}