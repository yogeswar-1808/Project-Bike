package loginpkg;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import dbPkg.Database;

public class UserDAOImpl implements UserDAO {

	
	
	public User get(String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = Database.getConnection();
		User user = null;
		String sql = "SELECT userId,username,password FROM Users WHERE userId =?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			String userId=rs.getString("userId");
			String username=rs.getString("username");
			String password=rs.getString("password");
			user=new User(userId,username,password);
		}
		return user;
		
		
		
	}

	public List<User> getAll() throws SQLException {
		
		List<User> users=new ArrayList<User>();
		// Created a list users to store the list of users 
		String sql="SELECT * from Users";
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			User user=new User(rs.getString("userId"),rs.getString("username"),rs.getString("password"));
			users.add(user);
		}
		
		return users;
	}
		
	public int insert(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=Database.getConnection();
		String sql = "INSERT INTO Users (userId,username,password) values (?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,user.getUserId());
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getPassword());
		
		int result=ps.executeUpdate();
		return result;
		
		
	}

	public int updateUser(User user, String old_username) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=Database.getConnection();
		
		String sql = "UPDATE Users set userid=?,username=?, password=? where username=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, user.getUserId());
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getPassword());
		ps.setString(4,old_username);
		
		int result=ps.executeUpdate();
		return result;
		
	}
	
	public int delete(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=Database.getConnection();
		
		String sql="DELETE from Users where userId=?";
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, user.getUserId());
		int result=ps.executeUpdate();
		return result;
	}

	
	public boolean checkAuth(String name, String pass)
			throws SQLException {
		Connection con = Database.getConnection();
		String sql = "SELECT userId,username,password FROM Users WHERE username =? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, pass);		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			return true;
		}else{
			return false;
		}
	}

	
	
	
	
}
