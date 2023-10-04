import java.util.Scanner;
import java.text.DecimalFormat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BuyingInventory {
    
    private record Item(String name, int price) {}

    private static final String MY_NAME = "Thomas";
    private static final DecimalFormat PRICE = new DecimalFormat("0.00");
    private static List<Item> items = Arrays.asList(null, new Item("Rope", 10), new Item("Torches", 15), new Item("Climbing equipment", 25),
        new Item("Clean water", 1), new Item("Machete", 20), new Item("Canoe", 300), new Item("Food supplies", 1));

    public static String getPriceList(int itemId, String name) {

        double discount = name.equals(MY_NAME) ? 0.5 : 1.0;

        String message;

        if (itemId >= 1 && itemId < items.size()) {
            String itemName = items.get(itemId).name();
            double price = discount * items.get(itemId).price();
            message = String.format("%s costs %s gold", itemName, PRICE.format(price));
        } else {
            message = "Invalid item identifier";
        }

        return message;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input item identifier:");
        for (int i = 1; i < items.size(); i++) {
            System.out.printf("%d: %s\n", i, items.get(i).name());
        }
        int item = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println(getPriceList(item, name));
    }
}