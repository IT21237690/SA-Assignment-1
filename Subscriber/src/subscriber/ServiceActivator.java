package subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import bakerypublisher.BakeryServicePublish;
import grocerypublisher.GroceryServicePublish;


public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start Subscriber Service");
		
		int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Select the publisher to subscribe:");
            System.out.println("1. Grocery");
            System.out.println("2. Bakery");
            System.out.print("Enter your choice (1 or 2): ");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);
        
        
        
        if(choice==1) {
        	
        	serviceReference = context.getServiceReference(GroceryServicePublish.class.getName());
    		GroceryServicePublish servicePublish = (GroceryServicePublish) context.getService(serviceReference);
    		
    		servicePublish.PriceList();
    		
    		int bill = servicePublish.Calculate(); 
    		String[] details = servicePublish.deliveryDetails();
    		
    		cutomerBill(details,bill);
        	
        }else if(choice==2) {
        	serviceReference = context.getServiceReference(BakeryServicePublish.class.getName());
    		BakeryServicePublish servicePublish = (BakeryServicePublish) context.getService(serviceReference);
    		
    		servicePublish.PriceList();
    		
    		int bill = servicePublish.Calculate();
    		String[] details = servicePublish.deliveryDetails();
    		
    		cutomerBill(details,bill);
        }
		
	}
	
	
	public void cutomerBill(String[] details,int bill) {
		
	    System.out.println("**********************************************");
        System.out.println("------------------ INVOICE -------------------");
        System.out.println("**********************************************");
        System.out.println(" ");
		
		System.out.println("Your Total Bill is Rs."+bill);
		System.out.println("Delivery Address: " + details[0]);
	    System.out.println("Payment Method: " + details[1]);
	    System.out.println(" ");
	    System.out.println("----------------------------------------------");
	    
	    System.out.println("Thank You");
	    System.out.println("Your order will be delivered with in 1 hour");
	    
	    System.out.println(" ");
	    System.out.println("**********************************************");
	    
	
	
}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Thank You and Good Bye !!!");
		context.ungetService(serviceReference);
		
	}
	
	

}
