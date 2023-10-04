import java.util.Scanner;

public class DoorHandler {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Door door = new Door();
        
        while(true) {
            System.out.printf("The door is %s. What do you want to do?\n" +
            "OPTIONS: (unlock|lock|open|close|change|break)\n", door.getState());
            
            String input = scanner.nextLine();
            if (input.equals("unlock")) {
                System.out.print("Enter passcode: ");
                String code = scanner.nextLine();
                System.out.println(door.unlock(code));
            } else if (input.equals("lock")) {
                System.out.println(door.lock());
            } else if (input.equals("open")) {
                System.out.println(door.open());
            } else if (input.equals("close")) {
                System.out.println(door.close());
            } else if (input.equals("change")) {
                System.out.print("Enter current passcode: ");
                String oldCode = scanner.nextLine();
                System.out.print("Enter new passcode: ");
                String newCode = scanner.nextLine();
                System.out.println(door.changeCode(oldCode, newCode));
            } else if (input.equals("break")) {
                System.out.println("Shutting down");
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}