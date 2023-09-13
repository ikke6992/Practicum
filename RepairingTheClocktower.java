import java.util.Scanner;

public class RepairingTheClocktower {

    public static String pendulum(int input) {
        if (input % 2 == 0) {
            return "Tick";
        } else {
            return "Tock";
        }
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insert number:");
        int input = scanner.nextInt();
        
        System.out.println(pendulum(input));
    }
}