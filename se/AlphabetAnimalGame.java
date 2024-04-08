package se;

import java.util.Scanner;

import java.util.Arrays;
import java.util.List;

public class AlphabetAnimalGame {
    
    private static List<String> animals = Arrays.asList(new String[]{"Aardvark", "Blue Whale", "Cheetah", "Dingo", "Eagle", "Fox", "Giraffe", "Ibex", "Jackdaw",
        "Kangaroo", "Lemur", "Meerkat", "Narwhal", "Okapi", "Penguin", "Quetzal", "Raccoon", "Snow Leopard", "Toucan", "Viper", "Warthog", "Yak", "Zebra"});
    
    public static String response(String animal) {
        
        Character lastLetter = animal.toUpperCase().charAt(animal.length() - 1);
        
        for (String response : animals) {
            if (lastLetter.equals(response.charAt(0))) {
                return response;
            }
        }
        return "I don't know any animal that starts with '" + lastLetter + "'. You win";
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Name an animal:");
        String animal = scanner.nextLine();
        
        System.out.println(response(animal + "!"));
    }
}