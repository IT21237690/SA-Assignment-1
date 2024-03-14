package com.resiride.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ResiRideActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Resi Ride publisher bundle Start");
		ResiRidePublish publishService = new ResiRidePublishImpl();
		publishServiceRegistration = context.registerService(ResiRidePublish.class.getName(), publishService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Resi Ride publisher bundle stop");
		publishServiceRegistration.unregister();
	}

}