package hangman;

import java.util.Scanner;

public class HangmanHandler {
    
    /**
     * Method to start playing Hangman with the computer
     * picking a random word to guess.
     */
    public static Hangman singleplayer() {
        return new Hangman();
    }
    
    /**
     * Method to start playing Hangman with one player entering
     * the word for the other player to guess.
     */
    public static Hangman multiplayer(Scanner scanner) {
        
        System.out.println("Enter a word:");
        String word = scanner.nextLine().toUpperCase();

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        
        return new Hangman(word);
    }
    
    /**
     * Plays a Hangman game.
     */
    public static void main(String[] args) {
        

        Scanner in = new Scanner(System.in);
        
        System.out.println("MULTIPLAYER? Y/N");        
        String multiplayer = in.nextLine();
        
        Hangman hangman = multiplayer.equalsIgnoreCase("Y") ? multiplayer(in) : singleplayer();
        System.out.print(hangman.displayWord());

        //Keep querying for guesses until the game is over.
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

        //Show whether the player has won, if not show what the word was.
        if (hangman.winner()) {
            System.out.println(" Congratulations! You found the word!");
        } else {
            System.out.println(" You've been hanged! The word was " + hangman.getWord());
        }
    }
}