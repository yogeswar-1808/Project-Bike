package customerpkg;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO customerDAO = new CustomerDAOImpl();

	public int insert(Customer customer) {
		// TODO Auto-generated method stub
		try {
			return customerDAO.insert(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Customer customer, String customerId) {
		// TODO Auto-generated method stub
		try {
			return customerDAO.update(customer, customerId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Customer customer) {
		// TODO Auto-generated method stub
		try {
			return customerDAO.delete(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Customer viewSingleRecord(String id) {
		// TODO Auto-generated method stub
		try {
			return customerDAO.get(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		try {
			return customerDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
}
