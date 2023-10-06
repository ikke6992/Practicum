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
    
    public Hangman() {
        word = wordPicker().toCharArray();
        guessedLetters = "_".repeat(word.length).toCharArray();
        incorrectGuesses = new char[MAX_LIVES];
        previousGuesses = new ArrayList<Character>();
        lives = MAX_LIVES;
    }
    
    public Hangman(String word) {
        this.word = word.toCharArray();
        guessedLetters = "_".repeat(this.word.length).toCharArray();
        incorrectGuesses = new char[MAX_LIVES];
        previousGuesses = new ArrayList<Character>();
        lives = MAX_LIVES;
    }
    
    public String wordPicker() {
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
    
    public boolean validGuess(char guess) {
        return !previousGuesses.contains(guess) && Character.isLetter(guess);
    }
    
    public void guessWord(String guess) {
        if (guess.equals(new String(word))) {
            for (int i = 0; i < word.length; i++) {
                guessedLetters[i] = word[i];
            }
        } else {
            lives--;
        }
    }
    
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
    
    public String displayWord() {
        StringBuilder builder = new StringBuilder("Word: ");
        builder.append(guessedLetters);
        return builder.toString();
    }
    
    public String displayTurn() {
        StringBuilder builder = new StringBuilder(" | Remaining: ");
        builder.append(lives);
        builder.append(" | Incorrect: ");
        builder.append(incorrectGuesses);
        builder.append(" | Guess: ");
        return builder.toString();
    }
    
    public boolean gameOver() {
        return winner() || lives == 0;
    }
    
    public boolean winner() {
        return Arrays.equals(word, guessedLetters);
    }
    
    public String getWord() {
        return new String(word);
    }

}