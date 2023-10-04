import java.util.Scanner;

public class DoorHandler {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Door door = new Door();
        
        while(true) {
            System.out.printf("The door is %s. What do you want to do?\n" +
            "OPTIONS: unlock, lock, open, close, change, break. ", door.getState());
            
            String input = scanner.nextLine();
            if (input.equals("unlock")) {
                System.out.print("Enter passcode: ");
                String code = scanner.nextLine();
                door.unlock(code);
            } else if (input.equals("lock")) {
                door.lock();
            } else if (input.equals("open")) {
                door.open();
            } else if (input.equals("close")) {
                door.close();
            } else if (input.equals("change")) {
                System.out.print("Enter current passcode: ");
                String oldCode = scanner.nextLine();
                System.out.print("Enter new passcode: ");
                String newCode = scanner.nextLine();
                door.changeCode(oldCode, newCode);
            } else if (input.equals("break")) {
                break;
            }
        }
    }
}