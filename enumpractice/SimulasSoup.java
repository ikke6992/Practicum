package enumpractice;

import java.util.Scanner;

public class SimulasSoup {

    public enum Soup {
        SOUP,
        STEW,
        GUMBO;
    }
    
    public enum Ingredient {
        MUSHROOMS,
        CHICKEN,
        CARROTS,
        POTATOES;
    }
    
    public enum Seasoning {
        SPICY,
        SALTY,
        SWEET;
    }
    
    private static Soup soup;
    private static Ingredient ingredient;
    private static Seasoning seasoning;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Soup soup = Soup.SOUP;
        Ingredient ingredient = Ingredient.POTATOES;
        Seasoning seasoning = Seasoning.SALTY;
        
        boolean valid = false;
        do {
            System.out.println("Input soup type. Options: Soup, Stew, Gumbo");
            String input = scanner.nextLine();
            
            if (input.toLowerCase().equals("soup")) {
                soup = Soup.SOUP;
                valid = true;
            } else if (input.toLowerCase().equals("stew")) {
                soup = Soup.STEW;
                valid = true;
            } else if (input.toLowerCase().equals("gumbo")) {
                soup = Soup.GUMBO;
                valid = true;
            }
        } while(!valid);
        
        valid = false;
        do {
            System.out.println("Input main ingredient. Options: Mushrooms, Chicken, Carrots, Potatoes");
            String input = scanner.nextLine();
            
            if (input.toLowerCase().equals("mushrooms")) {
                ingredient = Ingredient.MUSHROOMS;
                valid = true;
            } else if (input.toLowerCase().equals("chicken")) {
                ingredient = Ingredient.CHICKEN;
                valid = true;
            } else if (input.toLowerCase().equals("carrots")) {
                ingredient = Ingredient.CARROTS;
                valid = true;
            } else if (input.toLowerCase().equals("potatoes")) {
                ingredient = Ingredient.POTATOES;
                valid = true;
            }
        } while(!valid);
        
        valid = false;
        do {
            System.out.println("Input seasoning. Options: Spicy, Salty, Sweet");
            String input = scanner.nextLine();
            
            if (input.toLowerCase().equals("spicy")) {
                seasoning = Seasoning.SPICY;
                valid = true;
            } else if (input.toLowerCase().equals("salty")) {
                seasoning = Seasoning.SALTY;
                valid = true;
            } else if (input.toLowerCase().equals("sweet")) {
                seasoning = Seasoning.SWEET;
                valid = true;
            }
        } while(!valid);
        
        //if (soup.equals(Soup.STEW) && ingredient.equals(Ingredient.POTATOES)) {
        //    System.out.println("PO-TA-TOES! Boil 'em mash 'em stick 'em in a stew!");
        //} else {        
            System.out.printf(seasoning + " " + ingredient + " " + soup);
        //}
    }
}