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

    public static String getPrice(int item, String name) {

        double discount = name.equals(MY_NAME) ? 0.5 : 1.0;

        String message =
            switch (item) {
                case 1 -> String.format("Rope costs %s gold", PRICE.format(10 * discount));
                case 2 -> String.format("Torches costs %s gold", PRICE.format(15 * discount));
                case 3 -> String.format("Climbing equipment costs %s gold", PRICE.format(25 * discount));
                case 4 -> String.format("Clean water costs %s gold", PRICE.format(discount));
                case 5 -> String.format("Machete costs %s gold", PRICE.format(20 * discount));
                case 6 -> String.format("Canoe costs %s gold", PRICE.format(300 * discount));
                case 7 -> String.format("Food supplies costs %s gold", PRICE.format(discount));
                default -> "Invalid item identifier";
            };


        /*
        switch (item) {
            case 1:
                message = "Rope costs " + (10 * discount) + " gold";
                break;
            case 2:
                message = "Torches cost " + (15 * discount) + " gold";
                break;
            case 3:
                message = "Climbing equipment costs " + (25 * discount) + " gold";
                break;
            case 4:
                message = "Clean Water costs " + discount + " gold";
                break;
            case 5:
                message = "Machete costs " + (20 * discount) + " gold";
                break;
            case 6:
                message = "Canoe costs " + (300 * discount) + " gold";
                break;
            case 7:
                message = "Food Supplies cost " + discount + " gold";
                break;
            default:
                message = "Invalid item identifier";
                break;
        } 
        */
        return message;
    }

    public static String getPriceList(int item, String name) {

        double discount = name.equals(MY_NAME) ? 0.5 : 1.0;

        String message;

        if (item >= 1 && item < items.size()) {
            String itemName = items.get(item).name();
            double price = discount * items.get(item).price();
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