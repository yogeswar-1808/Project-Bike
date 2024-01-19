package customerpkg;

public class Customer {
	private String customerId;
	private String name;
	private String address;
	private String contact;
	
	public Customer(String customerId,String name, String address, String contact) {
		super();
		this.customerId=customerId;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
