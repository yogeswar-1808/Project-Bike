package servicepkg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbPkg.Database;


public class ServiceDaoImplementation implements ServiceDao{

	public Service get(String id) throws SQLException {
		Connection con = Database.getConnection();
		Service service = null;
		String sql = "SELECT serviceId,description,cost FROM service WHERE serviceId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			String serviceId = rs.getString("serviceId");
			String description = rs.getString("description");
			int charges = rs.getInt("cost");
			
			service = new Service(serviceId, description, charges);
		}
		return service;
	}

	public List<Service> getAll() throws SQLException {
		List<Service> services=new ArrayList<Service>();
		String sql="SELECT * from service";
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Service service=new Service(rs.getString("serviceid"),rs.getString("description"),rs.getInt("cost"));
			services.add(service);
		}
		return services;
	}

	public int save(Service service) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Service service) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "INSERT INTO service VALUES(? , ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, service.getServiceId());
		ps.setString(2, service.getDescription());
		ps.setInt(3, (int) service.getCharges());
		
		int result = ps.executeUpdate();
		ps.close();
		
		return result;
	}

	public int update(Service service, String serviceId) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "UPDATE service set serviceId = ?, description = ?, cost = ? where serviceid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, service.getServiceId());
		ps.setString(2, service.getDescription());
		ps.setInt(3, (int) service.getCharges());
		ps.setString(4, serviceId);
		
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}

	public int delete(Service service) throws SQLException {
		Connection con = Database.getConnection();
		String sql = "DELETE FROM service where serviceId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, service.getServiceId());
		int res = ps.executeUpdate();
		ps.close();
		return res;
	}
	
	

}
