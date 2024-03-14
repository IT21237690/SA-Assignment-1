package laundry_service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration laundryServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Laundry Service Start!");
		
		LaundryService laundry = new LaundryService_Imp();		
		laundryServiceRegistration = context.registerService(LaundryService.class.getName(), laundry, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Laundry Service Stop");
		laundryServiceRegistration.unregister();


	}

}
