import java.sql.Connection;

import servicepkg.ControllerService;
import java.sql.SQLException;
import java.util.Scanner;

import Appointmentpkg.AppointmentController;

import loginpkg.LoginAuthController;
import loginpkg.LoginController;
import vehicle.VehicleController;
import technicianpkg.TechnicianController;
import dbPkg.Database;
import customerpkg.CustomerController;
public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con= Database.getConnection();
		if(con!=null){
			System.out.println("Connection Sucessfull");
		}else{
			System.out.println(" Connection Failed ");
		}
		int choice;
		boolean loop=true;
		boolean isLoggedIn = LoginAuthController.main(null);
		if(isLoggedIn){
		while(loop){
			System.out.println("1. Customer");
			System.out.println("2. Update/DeletLogin");
			System.out.println("3. Technician");
			System.out.println("4. Service");
			System.out.println("5. Vehicle");
			System.out.println("6. Appointment");
			System.out.println("0. Exit");
			System.out.print("Enter your choice= ");
			choice=sc.nextInt();
			
			switch(choice){
			case 0:System.out.println("Exiting...");
					loop=false;
					System.exit(0);
					break;
			case 1:CustomerController.main(null);
				break;
			case 2:LoginController.main(null);
				break;
			case 3:TechnicianController.main(null);
				break;
			case 4:ControllerService.main(null);
				break;
			case 5:VehicleController.main(null);
				break;
			case 6:AppointmentController.main(null);
				break;
			}
			
		}
		}
	}

}
