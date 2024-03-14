package bakerypublisher;

import java.util.Scanner;

public class ServicePublishImpl implements BakeryServicePublish {
	
	@Override
	public void PriceList() {
		

        System.out.println("*************************************");
        System.out.println("Welcome to the Bakery");
        System.out.println("*************************************");
        
		 System.out.println("Available Items:");
         System.out.println("1. Tea bun          -   Rs. 50");
         System.out.println("2. Pastry           -   Rs.100");
         System.out.println("3. Kibula Bun       -   Rs. 80");
         System.out.println("4. Egg Bun          -   Rs.120");
         
	}

	@Override
	public int Calculate() {
		
		int total = 0;
        boolean continueShopping = true;

        Scanner sc = new Scanner(System.in);
        
        int[] items = new int[5]; 
        int[] quantities = new int[5];

        while (continueShopping) {

            System.out.println("Enter the number of the item you would like to buy:");
            int choice = sc.nextInt();

            System.out.println("Enter the quantity:");
            int quantity = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected " + quantity + " units of Tea bun - Rs.50 each");
                    total += 50 * quantity;
                    break;
                case 2:
                    System.out.println("You selected " + quantity + " units of Pastry - Rs.100 each");
                    total += 100 * quantity;
                    break;
                case 3:
                    System.out.println("You selected " + quantity + " units of Kibula Bun - Rs.80 each");
                    total += 80 * quantity;
                    break;
                case 4:
                    System.out.println("You selected " + quantity + " units of Egg Bun - Rs.120 each");
                    total += 120 * quantity;
                    break;          

                default:
                    System.out.println("Invalid choice. Please select a valid item.");
            }
            
            items[choice - 1] += quantity; 
            quantities[choice - 1] += quantity;

            
            System.out.println("Do you want to buy more items? (y/n)");
            sc.nextLine();
            String userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("n")) {
                continueShopping = false;
            }
        }

        return total;
	}
	
	@Override
	public String[] deliveryDetails() {
		
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Enter your dilivery address ");
		 String address = sc.nextLine().toLowerCase();
         
         System.out.println("Select Your Payment Methode");
         System.out.println("1 - Cash");
         System.out.println("2 - Bank Card");
         int choice = sc.nextInt();
         
         PaymentMethodFactory methodFactory;
         
         switch (choice) {
         case 1:
             methodFactory = new CashDeliveryMethodFactory();
             break;
         case 2:
             methodFactory = new BankCardMethodFactory();
             break;
         default:
             System.out.println("Invalid Input");
             return null; 
         }
         
         String pmethode = methodFactory.createPaymentMethod();
         
         String[] result = {address, pmethode};
         return result;
        
		
	}

}

