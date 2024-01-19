package technicianpkg;
import java.sql.SQLException;
import java.util.List;
public interface TechnicianDAO {
	Technician get(String id) throws SQLException;
	List<Technician> getAll() throws SQLException;
	int insert(Technician technician) throws SQLException;
	int update(Technician technician,String technicianId) throws SQLException;
	int delete(Technician technician) throws SQLException;

}
