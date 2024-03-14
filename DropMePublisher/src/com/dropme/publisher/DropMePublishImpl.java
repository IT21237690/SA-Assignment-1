package com.dropme.publisher;

import java.util.Scanner;

public class DropMePublishImpl implements DropMePublish{

	@Override
	public String Bill() {
		int total = 0;
        boolean bookRide = true;

        Scanner sc = new Scanner(System.in);
        StringBuilder table = new StringBuilder();


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to Drop Me Transportation Service");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        table.append("| Type       | Km    |  Total  |\n");

        while (bookRide) {
            System.out.println("Available Vehiclee Options:");
            System.out.println("1. Bike 1passenger  - LKR 50  per Km");
            System.out.println("2. Tuk  2passengers - LKR 60  per Km");
            System.out.println("3. Mini 3passengers - LKR 100 per Km");
            
            System.out.println("Enter the number of Km:");

            int distance = sc.nextInt();

            int bikePrice = distance * 50; 
            int tukPrice = distance * 60;
            int miniPrice = distance * 100; 

            System.out.println("Price for each vehicle for the entered Km:");
            System.out.println("1.Bikes: with a total of LKR: " + bikePrice);
            System.out.println("2.Tuks:  with a total of LKR: " + tukPrice);
            System.out.println("3.Mini:  with a total of LKR: " + miniPrice);
            
            System.out.println("Enter the number of the vehicle you would like to book:");
            
            int choice = sc.nextInt();

            switch (choice) {
            case 1:
                table.append(String.format("| Bikes      | %-10d |  LKR %-4d |\n", distance,  bikePrice));
                total += distance * 50;
                break;
            case 2:
                table.append(String.format("| Tuks       | %-10d | LKR %-4d |\n", distance, tukPrice));
                total += distance * 60;
                break;
            case 3:
                table.append(String.format("| Mini       | %-10d | %-8d | LKR %-4d |\n", distance, miniPrice));
                total += distance * 100;
                break;
            default:
                System.out.println("Invalid choice. Please select a valid choice.");
        }

            // Ask if the user wants to book another ride
            System.out.println("Do you want to book another ride? (y/n)");
            sc.nextLine();
            String userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("n")) {
                bookRide = false;
            }else{
            	
            }
        }

        table.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        table.append("Your Total Bill is LKR: " + total + "\n");

        return table.toString();
	}

}
