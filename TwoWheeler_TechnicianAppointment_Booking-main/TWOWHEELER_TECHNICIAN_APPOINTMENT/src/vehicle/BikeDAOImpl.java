package vehicle;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import dbPkg.Database;


public class BikeDAOImpl implements BikeDAO{

	public Bike get(String id) throws SQLException {
		Connection con=Database.getConnection();
		Bike bike=null;
		
		String sql = "SELECT bike_no,model,colour FROM bike WHERE bike_no = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			String bike_no=rs.getString("bike_no");
			String model=rs.getString("model");
			String colour=rs.getString("colour");
			
			bike=new Bike(bike_no,model,colour);
		}
		return bike;
	}

	public List<Bike> getAll() throws SQLException {
		List<Bike> bikes=new ArrayList<Bike>();
		String sql="SELECT * from BIKE";
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Bike bike=new Bike(rs.getString("bike_no"),rs.getString("model"),rs.getString("colour"));
			bikes.add(bike);
		}
		
		return bikes;
	}


	public int insert(Bike bike) throws SQLException {
		Connection con=Database.getConnection();
		
		String sql = "INSERT INTO bike(bike_no,model,colour) values (?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, bike.getBike_no());
		ps.setString(2, bike.getModel());
		ps.setString(3, bike.getColour());
		
		int result=ps.executeUpdate();
		return result;
		
	}

	public int update(Bike bike,String old_bike_no) throws SQLException {
		Connection con=Database.getConnection();
		
		String sql = "UPDATE bike set bike_no= ?, model=?, colour=? where bike_no=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, bike.getBike_no());
		ps.setString(2, bike.getModel());
		ps.setString(3, bike.getColour());
		ps.setString(4,old_bike_no);
		
		int result=ps.executeUpdate();
		return result;
		
		
	}

	public int delete(Bike bike) throws SQLException {
		Connection con=Database.getConnection();
		
		String sql="DELETE from bike where bike_no=?";
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, bike.getBike_no());
		int result=ps.executeUpdate();
		return result;
		
	}
	
	
}
