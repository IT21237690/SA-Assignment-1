package com.dropme.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class DropMeActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;


	public void start(BundleContext context) throws Exception {
		System.out.println("Drop Me publisher bundle Start");
		DropMePublish publishService = new DropMePublishImpl();
		publishServiceRegistration = context.registerService(DropMePublish.class.getName(), publishService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Drop Me publisher bundle stop");
		publishServiceRegistration.unregister();
	}

}
