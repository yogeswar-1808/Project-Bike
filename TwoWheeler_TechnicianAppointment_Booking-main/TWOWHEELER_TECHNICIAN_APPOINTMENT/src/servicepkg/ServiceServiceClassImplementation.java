package servicepkg;
import java.sql.SQLException;
import java.util.List;


public class ServiceServiceClassImplementation implements ServiceServiceClass {
	ServiceDao servicedao = new ServiceDaoImplementation();
	public int addService(Service service) {
		// TODO Auto-generated method stub
		try {
			return servicedao.insert(service);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int modifyService(Service service, String serviceId) {
		
		try {
			return servicedao.update(service, serviceId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteService(Service service) {
		try {
			return servicedao.delete(service);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Service viewSingleRecord(String id) {
		// TODO Auto-generated method stub
		try {
			return servicedao.get(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Service> getAllService() {
		// TODO Auto-generated method stub
		try {
			return servicedao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
