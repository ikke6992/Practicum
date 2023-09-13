import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word:");
        String word = scanner.nextLine().toUpperCase();

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        int turn = 0;
        boolean winner = false;
        char[] letters = word.toCharArray();
        char[] guessedLetters = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            guessedLetters[i] = '_';
        }

        System.out.println(new String(guessedLetters));

        do {
            System.out.println("What is your next guess?");
            String guess = scanner.nextLine().toUpperCase();

            if (guess.length() != 1) {
                if (guess.equals(word)) {
                    winner = true;
                    for (int i = 0; i < letters.length; i++) {
                        guessedLetters[i] = letters[i];
                    }
                } else {
                    System.out.println("That guess is incorrect");
                }
            } else {
                char letter = guess.charAt(0);
                for (int i = 0; i < letters.length; i++) {
                    if (letter == letters[i]) {
                        guessedLetters[i] = letter;
                    }
                }
            }
            String guessedWord = new String(guessedLetters);
            if (guessedWord.equals(word)) {
                winner = true;
            }
            System.out.println(guessedWord);

            turn++;
        } while (!winner && turn < 10);

        if (winner) {
            System.out.println("Congratulations! You found the word!");
        } else {
            System.out.println("You've been hanged! The word was " + word);
        }
    }
}