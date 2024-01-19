package loginpkg;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

	UserDAO userDAO=new UserDAOImpl();
	
	public User getUserUsingUserId(String userId) {
		// TODO Auto-generated method stub
		try {
			return userDAO.get(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<User> allRecords() {
		// TODO Auto-generated method stub
		try {
			return userDAO.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		try {
			return userDAO.insert(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateUser(User user, String old_userId) {
		// TODO Auto-generated method stub
		try {
			return userDAO.updateUser(user,old_userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			return userDAO.delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean checkAuthentication(String username, String password) {
		try{
			return userDAO.checkAuth(username, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	
}
