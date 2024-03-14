package com.resiride.publisher;

import java.util.Scanner;

public class ResiRidePublishImpl implements ResiRidePublish {

	@Override
	public String Bill() {
		
		int total = 0;
        boolean bookRide = true;

        Scanner sc = new Scanner(System.in);
        StringBuilder table = new StringBuilder();


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to Resi Ride Transportation Service");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        table.append("| Type       | Passengers | Vehicles | Total   |\n");

        while (bookRide) {
            System.out.println("Available Vehiclee Options:");
            System.out.println("1. Bike 1passenger  - LKR 300");
            System.out.println("2. Tuk  2passengers - LKR 500");
            System.out.println("3. Mini 3passengers - LKR 700");
            
            System.out.println("Enter the number of passengers:");

            int numPassengers = sc.nextInt();

            int bikes = numPassengers / 1; 
            int tuks = (int) Math.ceil((double) numPassengers / 2);
            int minis = (int) Math.ceil((double)numPassengers / 3); 

            System.out.println("Number of vehicles needed:");
            System.out.println("1.Bikes: " + bikes +  " with a total of LKR: " + bikes*300);
            System.out.println("2.Tuks: " + tuks + " with a total of LKR: " + tuks*500);
            System.out.println("3.Mini: " + minis + " with a total of LKR: " + minis*700);
            
            System.out.println("Enter the number of the vehicle you would like to book:");
            
            int choice = sc.nextInt();

            switch (choice) {
            case 1:
                table.append(String.format("| Bikes      | %-10d | %-8d | LKR %-4d |\n", numPassengers, bikes, bikes * 300));
                total += bikes * 300;
                break;
            case 2:
                table.append(String.format("| Tuks       | %-10d | %-8d | LKR %-4d |\n", numPassengers, tuks, tuks * 500));
                total += tuks * 500;
                break;
            case 3:
                table.append(String.format("| Mini       | %-10d | %-8d | LKR %-4d |\n", numPassengers, minis, minis * 700));
                total += minis * 700;
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

