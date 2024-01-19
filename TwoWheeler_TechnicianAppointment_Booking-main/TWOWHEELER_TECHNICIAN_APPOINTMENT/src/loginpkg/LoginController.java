package loginpkg;

import java.util.List;
import java.util.Scanner;




public class LoginController {

//	/**
//	 * @param args
//	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		UserService userService = new UserServiceImpl();		
		String userId,username,password;
		int loop_open=1,choice;
		do
		{
			System.out.println("1. Add new User");
			System.out.println("2. Update User Details");
			System.out.println("3. Delete User details");
			System.out.println("4. View User details by UserId");
			System.out.println("5. View all User details");
			System.out.println("9. Main Menu");
			System.out.println("0. Exit");
			System.out.println("Enter your choice= ");
			choice= sc.nextInt();
			switch(choice){
			case 0:System.out.println("Exiting...");
					System.exit(0);
					break;
			case 1:System.out.println("Enter UserId: ");
					userId=sc.next();
					System.out.println("Enter UserName: ");
					username=sc.next();
					System.out.println("Enter password: ");
					password=sc.next();
			
					User user1 = new User(userId,username,password);
					int records_inserted=userService.addUser(user1);
					System.out.println("Total records inserted: "+records_inserted);
					break;
			case 2:
				System.out.println("Enter UserId whose records to be updated: ");
				String old_userId=sc.next();
				User user2=userService.getUserUsingUserId(old_userId);
				if(user2==null)
					System.out.println("No records found");
				else{
					System.out.println("Enter new userId: ");
					userId=sc.next();
					System.out.println("Enter new username: ");
					username=sc.next();
					System.out.println("Enter new password: ");
					password=sc.next();
					
					user2.setUserId(userId);
					user2.setUsername(username);
					user2.setPassword(password);;
					
					int records_updated=userService.updateUser(user2, old_userId);
					System.out.println(records_updated+" Record updated");
				}
				break;
			case 3:
				System.out.println("Enter userId whose records to be deleted: ");
				userId=sc.next();
				User user3=userService.getUserUsingUserId(userId);
				if(user3==null)
					System.out.println("No records found");
				else
				{
					int records_deleted=userService.deleteUser(user3);
					System.out.println(records_deleted+" Record deleted");
				}
				break;
			case 4:
				System.out.println("Enter UserId: ");
				userId=sc.next();
				User user4= userService.getUserUsingUserId(userId);
				if(user4==null)
					System.out.println("No records found");
				else
				{
					System.out.println("UserId : "+ user4.getUserId());
					System.out.println("Username: "+ user4.getUsername());
					System.out.println("Password: "+ user4.getPassword());
					
				}
				break;
			case 5:
				List<User> users=userService.allRecords();
				for(User user_itr: users)
				{
					System.out.println("UserId is : "+ user_itr.getUserId());
					System.out.println("Username is : "+ user_itr.getUsername());
					System.out.println("Password is : "+ user_itr.getPassword());
					System.out.println("---------------------------------------------");
				}
				
				break;
			case 9: return;
			default:
				System.out.println("Wrong Choice!");
				break;
			}

		}while(loop_open==1);
	}

}
