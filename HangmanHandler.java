import java.util.Scanner;

public class HangmanHandler {
    
    public static Hangman singleplayer() {
        return new Hangman();

    }
    
    public static Hangman multiplayer(Scanner scanner) {
        
        System.out.println("Enter a word:");
        String word = scanner.nextLine().toUpperCase();

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        
        return new Hangman(word);
        
    }
    
    public static void main(String[] args) {
        

        Scanner in = new Scanner(System.in);
        
        System.out.println("MULTIPLAYER? Y/N");        
        String multiplayer = in.nextLine();
        
        Hangman hangman = multiplayer.equalsIgnoreCase("Y") ? multiplayer(in) : singleplayer();
        System.out.print(hangman.displayWord());

        do {  
            System.out.print(hangman.displayTurn());
            String guess = in.nextLine().toUpperCase();

            if (guess.length() != 1) {
                hangman.guessWord(guess);
            } else {
                char letter = guess.charAt(0);
                if (hangman.validGuess(letter)) {
                    hangman.guessLetter(letter);
                }
            }
            
            System.out.print(hangman.displayWord());
        } while (!hangman.gameOver());

        if (hangman.winner()) {
            System.out.println(" Congratulations! You found the word!");
        } else {
            System.out.println(" You've been hanged! The word was " + hangman.getWord());
        }
    }
}