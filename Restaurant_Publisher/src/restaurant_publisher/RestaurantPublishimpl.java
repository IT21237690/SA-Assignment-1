package restaurant_publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantPublishimpl implements RestaurantPublish {

    private Map<Integer, Integer> menu;

    public RestaurantPublishimpl() {
        menu = new HashMap<>();
        menu.put(1, 500); // Pizza
        menu.put(2, 200); // Fried Rice
        menu.put(3, 150); // Chicken Burger
        // Add more items to the menu if needed
    }

    @Override
    public int Calculate() {
        int total = 0;
        boolean continueShopping = true;
        boolean isDelivery = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("*************************************");
        System.out.println("Welcome to the Restaurant!!! ");
        System.out.println("*************************************");

        System.out.println("Is this for delivery or take away? (delivery/take away)");
        String deliveryOption = sc.nextLine().toLowerCase();

        if (deliveryOption.equals("delivery")) {
            total += 50;
            isDelivery = true;
        }

        while (continueShopping) {
            System.out.println("Available Items:");
            for (Map.Entry<Integer, Integer> entry : menu.entrySet()) {
                System.out.println(entry.getKey() + ". " + getItemName(entry.getKey()) + " - $" + entry.getValue());
            }

            System.out.println("Enter the number of the item you would like to buy:");

            int choice = sc.nextInt();

            if (!menu.containsKey(choice)) {
                System.out.println("Invalid choice. Please select a valid item.");
                continue;
            }

            System.out.println("Enter the quantity:");
            int quantity = sc.nextInt();

            System.out.println("You selected " + getItemName(choice) + " - $" + menu.get(choice) + " (Quantity: " + quantity + ")");
            total += menu.get(choice) * quantity;

            System.out.println("Do you want to buy more food? (y/n)");
            sc.nextLine(); // Consume newline left-over
            String userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("n")) {
                continueShopping = false;
            }
        }

        System.out.println("Your total bill is: $" + total);
        if (isDelivery) {
            System.out.println("Delivery Charge: $50");
        }
        return total;
    }

    private String getItemName(int choice) {
        switch (choice) {
            case 1:
                return "Pizza";
            case 2:
                return "Fried Rice";
            case 3:
                return "Chicken Burger";
            // Add more cases for additional items
            default:
                return "Unknown Item";
        }
    }
}
