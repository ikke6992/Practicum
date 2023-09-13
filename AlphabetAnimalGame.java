import java.util.Scanner;
import java.util.Map;

public class AlphabetAnimalGame {
    
    private static Map<Character, String> animals = Map.of('a', "Aardvark!", 'b', "Blue Whale!", 'c', "Cheetah!",
        'd', "Dingo!", 'e', "Eagle!", 'f', "Fox!", 'g', "Giraffe!", 'h', "Hippopotamus!", 'i', "Ibex!", 'j', "Jackdaw!",
        'k', "Kangaroo!", 'l', "Lemur!", 'm', "Meerkat!", 'n', "Narwhal!", 'o', "Okapi!", 'p', "Penguin!", 'q', "Quetzal!",
        'r', "Raccoon!", 's', "Snow Leopard!", 't', "Toucan!", 'v', "Viper!", 'w', "Warthog!", 'y', "Yak!", 'z', "Zebra!");
    
    public static String response(String animal) {
        
        char lastLetter = animal.charAt(animal.length() - 1).toLowerCase();
        
        if (animals.keySet().contains(lastLetter)) {
            return animals.get(lastLetter);
        } else {
            return "I don't know any animal that starts with '" + lastLetter + "'. You win!";
        /*
        switch (lastLetter) {
            case 'a', 'A':
                return "Aardvark!";
            case 'b', 'B':
                return "Blue Whale!";
            case 'c', 'C':
                return "Cheetah!";
            case 'd', 'D':
                return "Dingo!";
            case 'e', 'E':
                return "Eagle!";
            case 'f', 'F':
                return "Fox!";
            case 'g', 'G':
                return "Giraffe!";
            case 'h', 'H':
                return "Hippopotamus!";
            case 'i', 'I':
                return "Ibex!";
            case 'j', 'J':
                return "Jackdaw!";
            case 'k', 'K':
                return "Kangaroo!";
            case 'l', 'L':
                return "Lemur!";
            case 'm', 'M':
                return "Meerkat!";
            case 'n', 'N':
                return "Narwhal!";
            case 'o', 'O':
                return "Okapi!";
            case 'p', 'P':
                return "Penquin!";
            case 'q', 'Q':
                return "Quetzal!";
            case 'r', 'R':
                return "Raccoon!";
            case 's', 'S':
                return "Snow Leopard!";
            case 't', 'T':
                return "Toucan!";
            case 'v', 'V':
                return "Viper!";
            case 'w', 'W':
                return "Warthog!";
            case 'y', 'Y':
                return "Yak!";
            case 'z', 'Z':
                return "Zebra!";
            default:
                return "I don't know any animal that starts with '" + lastLetter + "'. You win!";
            */
        }
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Name an animal:");
        String animal = scanner.nextLine();
        
        System.out.println(response(animal));
    }
}