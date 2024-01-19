package technicianpkg;
import java.sql.*;
import java.util.*;

import dbPkg.Database;

public class TechnicianDaoImpl implements TechnicianDAO {

	public Technician get(String id) throws SQLException {

		Connection con= Database.getConnection();
		Technician technician = null;
		String sql = "SELECT technicianId,name,address,contactNo FROM Technician WHERE technicianId = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) 
		{
			String technicianId=rs.getString("technicianId");
			String name=rs.getString("name");
			String address=rs.getString("address");
			String contactNo = rs.getString("contactNo");
			
			technician = new Technician(technicianId,name,address,contactNo);
					
		}
		return technician;
		
	}

	public List<Technician> getAll() throws SQLException {
		List<Technician> technicians  = new ArrayList<Technician>();
		String sql="SELECT * from Technician";
		Connection con = Database.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Technician technician=new Technician(rs.getString("technicianId"),rs.getString("name"),rs.getString("address"),rs.getString("contactNo"));
			technicians.add(technician);
			
		}
		return technicians;
	}

	public int insert(Technician technician) throws SQLException {
		Connection con = Database.getConnection();
		String sql="INSERT INTO Technician(technicianId,name,address,contactNo) values (?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, technician.getTechnicianId());
		ps.setString(2, technician.getName());
		ps.setString(3, technician.getAddress());
		ps.setString(4,technician.getContactNo());
		int result = ps.executeUpdate();
	return result;
	}

	public int update(Technician technician, String old_technicianId)
			throws SQLException {
		Connection con=Database.getConnection();
		
		String sql = "UPDATE Technician set technicianId= ?, name=?, address=?, contactNo=? where technicianId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, technician.getTechnicianId());
		ps.setString(2, technician.getName());
		ps.setString(3, technician.getAddress());
		ps.setString(4,technician.getContactNo());
		ps.setString(5,old_technicianId);
		int result=ps.executeUpdate();
		return result;
		
		
	}

	public int delete(Technician technician) throws SQLException {
		Connection con=Database.getConnection();
		
		String sql="DELETE from technician where technicianId=?";
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, technician.getTechnicianId());
		int result=ps.executeUpdate();
		return result;
	}
	
	
	
	

}
