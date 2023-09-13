import java.util.Scanner;

public class SecondsToHoursMinutesAndSeconds {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input seconds:");
        int allSeconds = scanner.nextInt();
        
        int onlySeconds = allSeconds % 60;
        int allMinutes = allSeconds/60;
        int onlyMinutes = allMinutes % 60;
        int allHours = allMinutes/60;
        int onlyHours = allHours % 24;
        
        System.out.println(onlyHours + ":" + onlyMinutes + ":" + onlySeconds);
    }
}