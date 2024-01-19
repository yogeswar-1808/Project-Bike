package technicianpkg;


public class Technician {
	private String technicianId;
	private String name;
	private String address;
	private String contactNo;
	
	public Technician(String technicianId, String name, String address,String contactNo) {
		super();
		this.technicianId = technicianId;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
	}
	
	
	public String getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
	

}
