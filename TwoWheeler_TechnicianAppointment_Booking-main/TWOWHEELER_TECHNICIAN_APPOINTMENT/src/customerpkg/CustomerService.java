package customerpkg;

import java.util.List;

public interface CustomerService {
	int insert(Customer customer);
	int update(Customer customer,String customerId);
	int delete(Customer customer);
	Customer viewSingleRecord(String id);
	List<Customer> getAllCustomer();
}
