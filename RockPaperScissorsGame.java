import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
            RockPaperScissors game = new RockPaperScissors(scanner);
            int player1Wins = 0;
            int player2Wins = 0;
            int draws = 0;
            
            while(true) {
                System.out.println("Player 1:");        
                RockPaperScissors.Shoot player1Shoot = game.shoot();
                
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                
                System.out.println("Player 2:");
                RockPaperScissors.Shoot player2Shoot = game.shoot();
                
                if (game.winner(player1Shoot, player2Shoot)) {
                    System.out.printf("%s BEATS %s, Player 1 WINS!\n", player1Shoot, player2Shoot);
                    player1Wins++;
                } else if (game.winner(player2Shoot, player1Shoot)) {
                    System.out.printf("%s BEATS %s, Player 2 WINS!\n", player2Shoot, player1Shoot);
                    player2Wins++;
                } else {
                    System.out.printf("BOTH picked %s, IT'S A DRAW!\n", player1Shoot);
                    draws++;
                }
                
                System.out.printf("SCORE: %d - %d, %d DRAWS\n", player1Wins, player2Wins, draws);
                
                System.out.println("Continue? Y/N");
                if (scanner.nextLine().equalsIgnoreCase("N")) {
                    break;
                }
            }
            
        }
}