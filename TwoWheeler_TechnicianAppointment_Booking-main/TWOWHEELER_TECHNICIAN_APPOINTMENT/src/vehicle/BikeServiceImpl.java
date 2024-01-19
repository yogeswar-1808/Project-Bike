package vehicle;
import java.util.List;
import java.sql.*;

public class BikeServiceImpl implements BikeService{
	BikeDAO bikeDAO=new BikeDAOImpl();

	public Bike getBikeByNumber(String id){
		try {
			return bikeDAO.get(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Bike> allRecords() {
		try {
			return bikeDAO.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addBike(Bike bike) {
		try {
			return bikeDAO.insert(bike);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateBike(Bike bike,String old_bike_no) {
		try {
			return bikeDAO.update(bike,old_bike_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteBike(Bike bike) {
		try {
			return bikeDAO.delete(bike);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
