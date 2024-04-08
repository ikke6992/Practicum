package hangman;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
    
    private char[] word;
    private char[] guessedLetters;
    private char[] incorrectGuesses;
    private ArrayList<Character> previousGuesses;
    private static final int MAX_LIVES = 5;
    private int lives;
    
    /**
     * Creates an instance of Hangman with a random word.
     */
    public Hangman() {
        this.word = wordPicker().toCharArray();
        guessedLetters = "_".repeat(this.word.length).toCharArray();
        incorrectGuesses = new char[MAX_LIVES];
        previousGuesses = new ArrayList<Character>();
        lives = MAX_LIVES;
    }
    
    /**
     * Creates an instance of Hangman with the given word.
     */
    public Hangman(String word) {
        this.word = word.toCharArray();
        guessedLetters = "_".repeat(this.word.length).toCharArray();
        incorrectGuesses = new char[MAX_LIVES];
        previousGuesses = new ArrayList<Character>();
        lives = MAX_LIVES;
    }
    
    /**
     * Picks a random word from words.txt file.
     */
    private String wordPicker() {
        List<String> words;
        try {
            words = Files.readAllLines(Paths.get("words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return "HELLO";
        }
        
        Random random = new Random();
        return words.get(random.nextInt(words.size())).toUpperCase();
    }
    
    /**
     * Checks whether a character hasn't been guessed before and is a letter.
     */
    public boolean validGuess(char guess) {
        return !previousGuesses.contains(guess) && Character.isLetter(guess);
    }
    
    /**
     * Checks whether a guessed word is the word to be guessed. If so,
     * sets guessedLetters to the letters of the word. If not,
     * the amount of lives is reduced.
     */
    public void guessWord(String guess) {
        if (guess.equals(new String(word))) {
            for (int i = 0; i < word.length; i++) {
                guessedLetters[i] = word[i];
            }
        } else {
            lives--;
        }
    }
    
    /**
     * Checks whether a guessed character is contained in the word. If so,
     * every instance of that character in the word is inserted in guessedLetters.
     * If not, the amount of lives is reduced.
     */
    public void guessLetter(char guess) {
        boolean contains = false;
        for (int i = 0; i < word.length; i++) {
            if (guess == word[i]) {
                guessedLetters[i] = guess;
                contains = true;
            }
        }
        if (!contains) {
            incorrectGuesses[MAX_LIVES-lives] = guess;
            lives--;
        }
        previousGuesses.add(guess);
    }
    
    /**
     * Displays guessedLetters.
     */
    public String displayWord() {
        return "Word " + String.valueOf(guessedLetters);
    }
    
    /**
     * Displays the remaining lives, every incorrect character that has been guessed
     * and a query for the next guess.
     */
    public String displayTurn() {
        StringBuilder builder = new StringBuilder(" | Remaining: ");
        builder.append(lives);
        builder.append(" | Incorrect: ");
        builder.append(incorrectGuesses);
        builder.append(" | Guess: ");
        return builder.toString();
    }
    
    /**
     * Checks whether the game has ended. It ends when the player has won or
     * the amount of lives has been reduced to 0.
     */
    public boolean gameOver() {
        return winner() || lives == 0;
    }
    
    /**
     * Checks whether the player has won. The player wins if guessedLetters
     * is equal to the word to be guessed.
     */
    public boolean winner() {
        return Arrays.equals(word, guessedLetters);
    }
    
    /**
     * Gets the word to be guessed.
     */
    public String getWord() {
        return new String(word);
    }

}