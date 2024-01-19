package dbPkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
//	"jdbc:oracle:thin:@localhost:1522:xe"
	static String jdbcUrl = "jdbc:oracle:thin:@localhost:1522:xe";
	static String username = "NAGA";
	static String password = "system";
	private Database(){}
	
	public static Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=DriverManager.getConnection( jdbcUrl,username,password); 
		;
		return con;	
	}
}
