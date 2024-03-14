package grocerypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Grocery Publisher Start");
		GroceryServicePublish publishService = new ServicePublishImpl();
		publishServiceRegistration = context.registerService(GroceryServicePublish.class.getName(), publishService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Grocery Publisher Stop");
		publishServiceRegistration.unregister();
	}

}