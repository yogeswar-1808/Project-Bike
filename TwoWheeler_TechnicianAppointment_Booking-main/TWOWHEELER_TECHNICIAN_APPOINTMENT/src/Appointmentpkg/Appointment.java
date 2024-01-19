package Appointmentpkg;
import vehicle.*;
import customerpkg.*;
import servicepkg.*;
import technicianpkg.*;
public class Appointment {
	private String appointmentId;
	private Customer customer= null;
	private Service service=null;
	private Technician technician=null;
	private Bike bike=null;
	CustomerService customerService = new CustomerServiceImpl();
	ServiceServiceClassImplementation serviceService = new ServiceServiceClassImplementation();
	TechnicianService technicianService = new TechnicianServiceImpl();		//to call all methods through bikeDAO
	BikeService bikeService = new BikeServiceImpl();	
	
	public Appointment(String appointmentId,String customerId,String serviceId,String technicianId,String bike_no){
		this.appointmentId=appointmentId;
		this.customer = customerService.viewSingleRecord(customerId);
		this.service = serviceService.viewSingleRecord(serviceId);
		this.technician = technicianService.getTechnicianById(technicianId);
		this.bike = bikeService.getBikeByNumber(bike_no);
		
	}
	public String getAppointementId() {
		return appointmentId;
	}
	public void setAppointementId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public Service getService() {
		return service;
	}
	public Bike getBike() {
		return bike;
	}
	public Technician getTechnician() {
		return technician;
	}
	public void setCustomer(String customerId) {
		this.customer = customerService.viewSingleRecord(customerId);
	}
	public void setService(String serviceId) {
		this.service = serviceService.viewSingleRecord(serviceId);
	}
	public void setTechnician(String technicianId) {
		this.technician = technicianService.getTechnicianById(technicianId);
	}
	public void setBike(String bike_no) {
		this.bike = bikeService.getBikeByNumber(bike_no);
	}
	public void setClass(){
		
	}
}
