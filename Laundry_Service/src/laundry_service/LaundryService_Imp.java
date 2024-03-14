package laundry_service;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class LaundryService_Imp implements LaundryService{
	
	@Override
	public void print() {
		
		
		float weight,total,Total = 0,minToAdd,TotalWeight = 0;
		int type;
		char ans;
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(today);
		
		LocalTime currentTime = LocalTime.now();
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		do {
			
			System.out.println("*****************************************\n");
			System.out.println("Welcome to 'Laundry Geek' Laundry Service\n");
			System.out.println("*****************************************\n");
			System.out.println("Instruction :");
			System.out.println("Maximum weight of the cloths is 10 kg.\n");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter the weight of the cloths : ");
			weight = sc.nextFloat();
			System.out.println("\n");
			
			if(weight > 10.0) {
				
				System.out.println("Maximum weight of the cloths is 10 kg, Lower the weight !!\n");
				
				do {
					System.out.print("Enter the weight of the cloths(Weight must be below 10kg) : ");
					weight = sc.nextFloat();
					System.out.println("\n");
				}while(weight > 10);				
			}
			
			TotalWeight = TotalWeight + weight;
			minToAdd = TotalWeight*15;
			
			
			do {
				System.out.println("Select Washing Type :");
				System.out.println("1 - Normal Wash (Per kilo RS.100)");
				System.out.println("2 - Hard Wash (Per kilo RS.150)\n");
				System.out.print("Select Your Washing type :");
				type = sc.nextInt();
				System.out.println("\n");
				
				if(type < 1 || type > 2) {
					System.out.println("You have entered the wrtong type !!\n");
				}
				
			}while(type < 1 || type > 2);
			
			if(type == 1) {
				total = weight*100;
			}
			else {
				total = weight*150;
			}
			
			System.out.print("Do you need another service ? (y/n) : ");
			ans = sc.next().charAt(0);
			System.out.println("\n");
			
			Total = Total + total;
			
		}while( ans == 'y' || ans == 'Y');
		
		LocalDateTime futureTime = currentDateTime.plusMinutes((long) minToAdd);
		
		System.out.println("*****************************************");
		System.out.println("              Laundry Geek               ");
		System.out.println("*****************************************\n");
		System.out.println("Date : " + formattedDate);
		System.out.println("Time : " + currentTime);
		System.out.println("Total bill is : LKR "+ Total);
		System.out.println("You cloths will be ready on : " + futureTime + "\n");
		System.out.println("*****************************************");
		System.out.println("*****************************************");
		
		
	}
	
	

}
