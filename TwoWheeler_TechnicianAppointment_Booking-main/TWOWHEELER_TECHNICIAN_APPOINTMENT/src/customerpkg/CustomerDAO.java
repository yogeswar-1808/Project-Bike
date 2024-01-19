package customerpkg;
import java.sql.*;
import java.util.List;
public interface CustomerDAO {
	Customer get(String id) throws SQLException;
	List<Customer> getAll() throws SQLException;
	int insert(Customer customer) throws SQLException;
	int update(Customer customer,String customerId) throws SQLException;
	int delete(Customer customer) throws SQLException;
}
