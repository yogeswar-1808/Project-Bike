package loginpkg;
public class User {
	private String userId;
	private  String username;
	private  String password;
	//boolean isAdmin;
	public User(String userId,String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public  String getUsername() {
		return username;
	}
	public  void setUsername(String username) {
		this.username = username;
	}
	public  String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
}
