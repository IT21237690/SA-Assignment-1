package bakerypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

ServiceRegistration publishServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Bakery Publisher Start");
		BakeryServicePublish publishService = new ServicePublishImpl();
		publishServiceRegistration = context.registerService(BakeryServicePublish.class.getName(), publishService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Bakery Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
