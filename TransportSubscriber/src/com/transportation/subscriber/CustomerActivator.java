package com.transportation.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.dropme.publisher.DropMePublish;
import com.resiride.publisher.ResiRidePublish;


public class CustomerActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	@Override
//	public void start(BundleContext context) throws Exception {
//		System.out.println("Start Subscriber Service");
//		serviceReference = context.getServiceReference(ResiRidePublish.class.getName());
//		ResiRidePublish servicePublish = (ResiRidePublish) context.getService(serviceReference);
//		
//		String rideDetails = servicePublish.Bill();
//        System.out.println(rideDetails);
//	}
	
	public void start(BundleContext context) throws Exception {
	    System.out.println("Customer bundle start");
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("===== Enter your Option (1,2) ====");
	    System.out.println("1. Book a ride inside residence."); 
	    System.out.println("2. Book a ride outside rescidence. ");
	    int option = scanner.nextInt();
	    
	    if (option == 1) {
	        // Call ResiRidePublish bundle
	        serviceReference = context.getServiceReference(ResiRidePublish.class.getName());
	        ResiRidePublish resiRideServicePublish = (ResiRidePublish) context.getService(serviceReference);
	        if (serviceReference == null) {
	            System.out.println("Resi Ride service is not available. Please try again later.");

	        }else {
	        String rideDetails = resiRideServicePublish.Bill();
	        System.out.println(rideDetails);
	        }
	    } else if (option == 2) {
	        // Check if the DropMePublish bundle is active
	        serviceReference = context.getServiceReference(DropMePublish.class.getName());
	        DropMePublish dropMeServicePublish = (DropMePublish) context.getService(serviceReference);

	        if (serviceReference == null) {
	            System.out.println("DropMe service is not available. Please try again later.");
	        }
	        else {
		        String rideDetails = dropMeServicePublish.Bill();
		        System.out.println(rideDetails);
		        }
	    } else {
	        System.out.println("Invalid option. Please choose 1 or 2.");
	    }
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Customer bundle stop ");
		context.ungetService(serviceReference);
		
	}

}
