package restaurant_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import restaurant_publisher.RestaurantPublish;

public class RestaurantActivator implements BundleActivator {
	

		ServiceReference serviceReference;
		
		@Override
		public void start(BundleContext context) throws Exception {
			System.out.println("Start Subscriber Service");
			serviceReference = context.getServiceReference(RestaurantPublish.class.getName());
			RestaurantPublish servicePublish = (RestaurantPublish) context.getService(serviceReference);
			
			int bill = servicePublish.Calculate();
			System.out.println("Your Total Bill is Rs."+bill);
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			System.out.println("Good Bye !!!");
			context.ungetService(serviceReference);
			
		}

	}
