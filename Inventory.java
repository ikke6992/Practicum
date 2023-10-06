import java.util.Scanner;

public class Inventory {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        Pack pack = new Pack(16, 30.0, 30.0);
        
        boolean run = true;
        do {
            System.out.println(pack);
            
            System.out.print("What would you like to add to the pack?\n" +
                "OPTIONS: (arrow|bow|rope|water|food|sword|end) ");
            String input = in.nextLine().toLowerCase();
            
            InventoryItem item = null;
            switch(input) {
                case "arrow" -> item = new ArrowItem();
                case "bow" -> item = new BowItem();
                case "rope" -> item = new RopeItem();
                case "water" -> item = new WaterItem();
                case "food" -> item = new FoodRationsItem();
                case "sword" -> item = new SwordItem();
                case "end" -> run = false;
                default -> System.out.println("Invalid item identifier");
            }
            
            if (item != null) {
                System.out.printf("%s has %sbeen added to the pack.\n", item, pack.add(item) ? "" : "NOT ");
            }
        } while(run);
        
    }
}