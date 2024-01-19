package vehicle;
import java.sql.SQLException;
import java.util.List;
public interface BikeDAO{
	Bike get(String id) throws SQLException;
	List<Bike> getAll() throws SQLException;
	int insert(Bike bike) throws SQLException;
	int update(Bike bike,String bike_no) throws SQLException;
	int delete(Bike bike) throws SQLException;
}