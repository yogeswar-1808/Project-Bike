package loginpkg;
import java.sql.SQLException;
import java.util.List;


public interface UserDAO {
	User get(String userId) throws SQLException;
	List<User> getAll() throws SQLException;
	int insert(User user) throws SQLException;
	int updateUser(User user,String old_userId) throws SQLException;
	int delete(User user) throws SQLException;
	boolean checkAuth(String username,String password)throws SQLException;
	
		
}
