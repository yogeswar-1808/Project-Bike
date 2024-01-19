package servicepkg;
import java.sql.SQLException;
import java.util.List;


public interface ServiceDao{
	Service get(String id) throws SQLException;
	List<Service> getAll() throws SQLException;
	int save(Service service) throws SQLException;
	int insert(Service service) throws SQLException;
	int update(Service service, String serviceId) throws SQLException;
	int delete(Service service) throws SQLException;
}
