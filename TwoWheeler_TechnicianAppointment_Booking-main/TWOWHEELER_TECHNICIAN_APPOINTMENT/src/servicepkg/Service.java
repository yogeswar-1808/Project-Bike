	package servicepkg;
	public class Service {
	private String serviceId;
	private String description;
	private int charges;
	
	public Service(){}
	
	public Service(String serviceId, String description, int charges){
		this.serviceId = serviceId;
		this.description = description;
		this.charges = charges;
	}
	
	public String getServiceId(){
		return serviceId;
	}
	
	public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}
	
}
