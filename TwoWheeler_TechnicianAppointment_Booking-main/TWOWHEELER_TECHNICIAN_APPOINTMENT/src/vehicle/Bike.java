package vehicle;
public class Bike {
	private String bike_no;
	private String model;
	private String colour;
	
	public Bike(String bike_no, String model, String colour) {
		super();
		this.bike_no = bike_no;
		this.model = model;
		this.colour = colour;
	}
	
	
	public String getBike_no() {
		return bike_no;
	}
	public void setBike_no(String bike_no) {
		this.bike_no = bike_no;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
}
