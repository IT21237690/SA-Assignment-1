package laundry_customer;

import laundry_service.LaundryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	
	ServiceReference laundryReference;

	public void start(BundleContext context) throws Exception {
		
		laundryReference = context.getServiceReference(LaundryService.class.getName());
		LaundryService laundrypublish = (LaundryService)context.getService(laundryReference);
		laundrypublish.print();
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Good Bye !");
		context.ungetService(laundryReference);
		
	}

}
