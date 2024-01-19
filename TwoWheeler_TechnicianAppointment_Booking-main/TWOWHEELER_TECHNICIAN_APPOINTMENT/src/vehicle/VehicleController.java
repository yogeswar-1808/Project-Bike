package vehicle;
import java.sql.*;
import java.util.*;
//import dbPkg.Database;
public class VehicleController {
	public static void main(String[] args) throws SQLException{
		Scanner sc=new Scanner(System.in);

		String bike_no,model,colour;

		
		BikeService bikeService = new BikeServiceImpl();		//to call all methods through bikeDAO
		
		int loop_open=1,choice;
		do
		{
			System.out.println("1. Enter bike details");
			System.out.println("2. Update bike model");
			System.out.println("3. Delete bike details");
			System.out.println("4. View bike details by bike number");
			System.out.println("5. View all bike details");
			System.out.println("9. Main Menu");
			System.out.println("0. Exit");
			System.out.println("Enter your choice= ");
			choice= sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter bike number: ");
				bike_no=sc.next();
				sc.nextLine();
				System.out.println("Enter bike model: ");
				model=sc.nextLine();
				System.out.println("Enter bike colour: ");
				colour=sc.nextLine();
				
				Bike bike_case1=new Bike(bike_no,model,colour);
				int records_inserted=bikeService.addBike(bike_case1);
				System.out.println("Total records inserted: "+records_inserted);
				break;
			case 2:
				System.out.println("Enter bike_no whose records to be updated: ");
				String old_bike_no=sc.next();
				Bike bike_case2=bikeService.getBikeByNumber(old_bike_no);
				if(bike_case2==null)
					System.out.println("No records found");
				else{
					System.out.println("Enter new bike number: ");
					bike_no=sc.next();
					System.out.println("Enter new bike model: ");
					model=sc.next();
					System.out.println("Enter new bike colour: ");
					colour=sc.next();
					
					
					bike_case2.setBike_no(bike_no);
					bike_case2.setModel(model);
					bike_case2.setColour(colour);
					
					int records_updated=bikeService.updateBike(bike_case2,old_bike_no);
					System.out.println(records_updated+" Record updated");
				}
				break;
			case 3:
				System.out.println("Enter bike_no whose records to be deleted: ");
				bike_no=sc.next();
				Bike bike_case3=bikeService.getBikeByNumber(bike_no);
				if(bike_case3==null)
					System.out.println("No records found");
				else
				{
					int records_deleted=bikeService.deleteBike(bike_case3);
					System.out.println(records_deleted+" Record deleted");
				}
				break;
			case 4:
				System.out.println("Enter bike number: ");
				bike_no=sc.next();
				Bike bike_case4= bikeService.getBikeByNumber(bike_no);
				if(bike_case4==null)
					System.out.println("No records found");
				else
				{
					System.out.println("Bike Number: "+ bike_case4.getBike_no());
					System.out.println("Model: "+ bike_case4.getModel());
					System.out.println("Colour: "+ bike_case4.getColour());
				}
				break;
			case 5:
				List<Bike> bikes=bikeService.allRecords();
				for(Bike bike_itr: bikes)
				{
					System.out.println("Bike Number: "+ bike_itr.getBike_no());
					System.out.println("Model: "+ bike_itr.getModel());
					System.out.println("Colour: "+ bike_itr.getColour());
					System.out.println("---------------------------------------------");
				}
				
				break;
			case 9: return;
			case 0:System.out.println("Exiting...");
					System.exit(0);
			default:
				System.out.println("Wrong Choice!");
				break;
			
			}
			System.out.println("Press 1 for the menu/0 to exit: ");
			loop_open=sc.nextInt();
		}while(loop_open==1);
		
	}

}
