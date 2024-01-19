package vehicle;
import java.util.*;
public interface BikeService {
	Bike getBikeByNumber(String id);
	List<Bike> allRecords();
	int addBike(Bike bike);
	int updateBike(Bike bike,String old_bike_no);
	int deleteBike(Bike bike);
}
