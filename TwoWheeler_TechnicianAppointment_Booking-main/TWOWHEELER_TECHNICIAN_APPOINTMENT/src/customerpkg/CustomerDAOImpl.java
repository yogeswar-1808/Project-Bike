package customerpkg;
import dbPkg.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

	
	public Customer get(String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = Database.getConnection();
		Customer customer = null;
		String sql = "SELECT customerId,Name,Address,Contact FROM Customer WHERE customerId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			String customerId = rs.getString("CustomerId");
			String name = rs.getString("Name");
			String address = rs.getString("Address");
			String contact = rs.getString("Contact");
			
			customer = new Customer(customerId,name,address,contact);
		}
		return customer;
	}


	public List<Customer> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		String sql="SELECT * from Customer";
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Customer customer = new Customer(rs.getString("customerId"),rs.getString("Name"),rs.getString("Address"),rs.getString("Contact"));
			customers.add(customer);
		}
		return customers;
	}

	
	public int insert(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = Database.getConnection();
		String sql = "INSERT INTO Customer VALUES(? , ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, customer.getCustomerId());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getAddress());
		ps.setString(4, customer.getContact());
		
		int result = ps.executeUpdate();
		ps.close();
		
		return result;
	}


	public int update(Customer customer, String old_userId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=Database.getConnection();
		String sql = "UPDATE Customer set customerId = ?, Name = ?, Address = ?, Contact = ? where customerId= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, customer.getCustomerId());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getAddress());
		ps.setString(4, customer.getContact());
		ps.setString(5, old_userId);
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}

	
	public int delete(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=Database.getConnection();
		String sql = "DELETE FROM Customer where customerId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, customer.getCustomerId());
		int res = ps.executeUpdate();
		ps.close();
		return res;
	}

}
