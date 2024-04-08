package se;

import java.util.Scanner;

public class ReverseAnInteger {

    public static int reverseInt(int integer) {
        int reverse = 0;
        int remainder = 0;
        while (integer != 0) {
            reverse = reverse * 10 + integer % 10;
            integer /= 10;
        }
        return reverse;
    }
    
    public static int reverseIntForLoop(int integer) {
        int reverse = 0;
        for (;integer != 0; integer /= 10) {
            reverse = reverse * 10 + integer % 10;
        }
        
        return reverse;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter an integer:");
        int integer = scanner.nextInt();
        
        System.out.println(reverseIntForLoop(integer));
    }
}