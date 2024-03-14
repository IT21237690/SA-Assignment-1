package restaurant_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class RestaurantActivator implements BundleActivator {

    private ServiceRegistration publishServiceRegistration;

    public void start(BundleContext context) throws Exception {
        System.out.println("Publisher Start");
        RestaurantPublish publishService = new RestaurantPublishimpl();
        publishServiceRegistration = context.registerService(RestaurantPublish.class.getName(), publishService, null);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Publisher Stop");
        publishServiceRegistration.unregister();
    }
}

