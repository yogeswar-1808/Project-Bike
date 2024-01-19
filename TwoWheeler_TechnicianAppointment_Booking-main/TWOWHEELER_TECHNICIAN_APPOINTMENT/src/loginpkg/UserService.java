package loginpkg;

import java.util.List;

public interface UserService {
	User getUserUsingUserId(String userId);
	List<User> allRecords();
	int addUser(User user);
	int updateUser(User user,String old_userId);
	int deleteUser(User user);
	boolean checkAuthentication(String username,String password);
}
