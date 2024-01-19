
package loginpkg;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import dbPkg.Database;

public class LoginAuthController {
	public static boolean main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		Connection con= Database.getConnection();
		String userId,username,password;
		boolean isLoggedIn=false;
		boolean loop=true;
		if(con==null) {
			System.out.println("Connection Failed");
		}
		UserService userService = new UserServiceImpl();
		int flag=0;
		int choice;
		while(loop)
		{
			System.out.println("1. New User Registration. ");
			System.out.println("2. User Login.  ");
			System.out.println("0. EXIT");
			choice= sc.nextInt();
			switch(choice)
			{
			case 0:System.out.println("Exiting...");
					loop = false;
					System.exit(0);
					break;
			case 1:
				System.out.println("Enter UserId");
				userId = sc.next();
				System.out.println("Enter the username : ");
				username=sc.next();
				System.out.println("Enter the password : ");
				password=sc.next();
				User user1 = new User(userId,username,password);
				
				int records_inserted=userService.addUser(user1);
				System.out.println("Total records inserted: "+records_inserted);
				break;
			case 2:
				System.out.println("Enter the username : ");
				username=sc.next();
				System.out.println("Enter the password : ");
				password=sc.next();
				isLoggedIn = userService.checkAuthentication(username, password);
				if(isLoggedIn){
					System.out.println("Logged In");
					loop=false;
				}else{
					System.out.println("Wrong Credentials");
					loop=true;
					flag+=1;
					System.out.println("Attempts Left "+ (3 - flag));
					if(flag==3){
						System.out.println(" Login failed");
						System.exit(0);
					}
				}
				break;
			default:
				System.out.println("Wrong Choice!");
				break;
			
			}
//			System.out.println("Press 1 for the menu/0 to exit: ");
//			loop_open=sc.nextInt();
		}
		if(isLoggedIn){
			return true;
		}else{
			return false;
		}
	}
}
