package pg;

public class Countdown {
    
    public static String countdown(int number) {
        if (number == 1) {
            return "1\n";
        } else {
            return number + "\n" + countdown(number-1);
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println(countdown(10));
    }
}