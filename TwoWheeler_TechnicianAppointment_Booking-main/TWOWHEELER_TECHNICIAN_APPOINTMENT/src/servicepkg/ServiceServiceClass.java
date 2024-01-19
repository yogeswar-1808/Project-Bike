package servicepkg;
import java.util.List;


public interface ServiceServiceClass {
	
	int addService(Service service);
	int modifyService(Service service, String serviceId);
	int deleteService(Service service);
	Service viewSingleRecord(String id);
	List<Service> getAllService();
}
