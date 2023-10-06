package puzzle;

import java.util.InputMismatchException;
import java.util.Scanner;

import myexceptions.InvalidMoveException;

public class PuzzleHandler {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Puzzle puzzle = new Puzzle();
        System.out.println(puzzle.display());
        
        do {
            try {
                System.out.print("Enter row: ");
                int x = in.nextInt();
                System.out.print("Enter column: ");
                int y = in.nextInt();
                puzzle.move(x, y);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("This is not a piece on the board");
            } catch (InputMismatchException e) {
                System.out.println("This is not a number");
            } finally {
                in.nextLine();
            }
            
            System.out.println(puzzle.display());
            
        } while (!puzzle.isSolved());
        
        System.out.println("Congratulations, you solved the puzzle!");
        
    }
}