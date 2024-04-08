package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

import myexceptions.InvalidMoveException;

public class TicTacToeHandler {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Player 1, please enter your name:");
        String naam1 = in.nextLine();
        
        System.out.println("Player 2, please enter your name:");
        String naam2 = in.nextLine();
        
        char piece1 = ' ';
        do {
            System.out.println(naam1 + ", with what piece do you want to play? Options: X/O");
            piece1 = in.nextLine().toUpperCase().charAt(0);
        } while (piece1 != 'X' && piece1 != 'O');
        
        TicTacToePlayer player1 = new TicTacToePlayer(naam1, piece1);
        TicTacToePlayer player2 = new TicTacToePlayer(naam2, player1.otherPiece());
        boolean anotherRound = true;
        
        TicTacToe game = new TicTacToe(player1, player2);
        //Runs the game
        do {
            //Runs a round of the game
            do {
                System.out.println(game.display());
                TicTacToePlayer player = game.next();
                
                //Runs a turn of the game
                boolean moveMade = false;
                do {
                    try {
                        System.out.println(player.getNaam() + ", where would you like to place your piece?");
                        int position = in.nextInt();
                        game.move(position, player.getPiece());
                        moveMade = true;
                    } catch (InvalidMoveException e) {
                        System.out.println(e.getMessage());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("This is not a position on the board");
                    } catch (InputMismatchException e) {
                        System.out.println("This is not a number");
                    } finally {
                        in.nextLine();
                    }
                } while (!moveMade);
                    
                
            } while (!game.gameOver());
            
            System.out.println(game.display());
            
            //Displays who won this round
            if (game.winner(player1.getPiece())) {
                System.out.println(player1.getNaam() + " WINS!");
            } else if (game.winner(player2.getPiece())) {
                System.out.println(player2.getNaam() + " WINS!");
            } else {
                System.out.println("It's a draw!");
            }
            
            //exits the game or resets the board
            System.out.println("Another round? Y/N");
            String next = in.nextLine();
            if (next.equalsIgnoreCase("N")) {
                anotherRound = false;
            } else {
                game.reset();
            }
        
        } while (anotherRound);
        
        
    }
}