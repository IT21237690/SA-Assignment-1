package grocerypublisher;

import java.util.Scanner;

public class ServicePublishImpl implements GroceryServicePublish {
	
	@Override
	public void PriceList() {
		

        System.out.println("*************************************");
        System.out.println("Welcome to the Grocery Shop");
        System.out.println("*************************************");
        
		 System.out.println("Available Items:");
         System.out.println("1. Sugar       1KG   -   Rs.100");
         System.out.println("2. Dhal        1KG   -   Rs.200");
         System.out.println("3. White Rice  1KG   -   Rs.150");
         System.out.println("4. Milk        1L    -   Rs. 80");
         
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
                    System.out.println("You selected " + quantity + " units of Sugar - Rs.100 each");
                    total += 100 * quantity;
                    break;
                case 2:
                    System.out.println("You selected " + quantity + " units of Dhal - Rs.200 each");
                    total += 200 * quantity;
                    break;
                case 3:
                    System.out.println("You selected " + quantity + " units of White Rice - Rs.150 each");
                    total += 150 * quantity;
                    break;
                case 4:
                    System.out.println("You selected " + quantity + " units of Milk - Rs.80 each");
                    total += 80 * quantity;
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

