package technician;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args)throws SQLExeceptions {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con= Database.getConnection();
		String technicianId,name,address,contactNo;
		if(con != null)
		{
			System.out.println("connection successful");
		}
		
		TechnicianService technicianService = new TechnicianServiceMain();		//to call all methods through bikeDAO
		
		int loop_open=1,choice;
		do
		{
			System.out.println("1. Enter technician details");
			System.out.println("2. Update technician model");
			System.out.println("3. Delete technician details");
			System.out.println("4. View technician details by technicianId");
			System.out.println("5. View all technician details");
			System.out.println("Enter your choice= ");
			choice= sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Technician id: ");
				technicianId=sc.next();
				sc.nextLine();
				System.out.println("Enter Technician name: ");
				name=sc.nextLine();
				System.out.println("Enter Technician address: ");
				address=sc.nextLine();
				System.out.println("Enter Technician contactNo: ");
				contactNo=sc.nextLine();
				
				Technician technician_case1=new Technician(technicianId,name,address,contactNo);
				int records_inserted=technicianService.addTechnician(technician_case1);
				System.out.println("Total records inserted: "+records_inserted);
				break;
			case 2:
				System.out.println("Enter TechnicianId whose records to be updated: ");
				String TechnicianId=sc.next();
				Technician technician_case2=technicianService.getTechnicianById(old_TechnicianId);
				if(bike_case2==null)
					System.out.println("No records found");
				else
				System.out.println("Enter new Technician id: ");
				technicianId=sc.next();
				
				System.out.println("Enter new Technician name: ");
				name=sc.nextLine();
				System.out.println("Enter new Technician address: ");
				address=sc.nextLine();
				System.out.println("Enter new Technician contactNo: ");
				contactNo=sc.nextLine();
				
					
					
					technician_case2.setTechnicianId(technicianId);
					technician_case2.setname(name);
					technician_case2.setaddress(address);
					technician_case2.setcontactNo(contactNo);
					
					int records_updated=technicianService.updateTechnician(technician_case2,old_technicianId);
					System.out.println(records_updated+" Record updated");
				break;
			case 3:
				System.out.println("Enter technicianId whose records to be deleted: ");
				technicianId=sc.next();
				Technician technician_case3=technicianService.getTechnicianById(technicianId);
				if(bike_case3==null)
					System.out.println("No records found");
				else
				{
					int records_deleted=technicianService.deleteTechnician(technician_case3);
					System.out.println(records_deleted+" Record deleted");
				}
				break;
			case 4:
				System.out.println("Enter bike number: ");
				technicianId=sc.next();
				Technician technician_case4= technicianService.gettechnicianById(technicianId);
				if(bike_case4==null)
					System.out.println("No records found");
				else
				{
					System.out.println("technicianId: "+ technician_case4.gettechnicianId());
					System.out.println("name: "+ technician_case4.getname());
					System.out.println("address: "+ technician_case4.getaddress());
					System.out.println("contactNo: "+ technician_case4.getcontactNo());
				}
				break;
			case 5:
				List<Technician> technician=technicianService.allRecords();
				for(Technician technician_itr: technician)
				{
					System.out.println("technicianId: "+ technician_itr.gettechnicianId());
					System.out.println("name: "+ technician_itr.getname());
					System.out.println("address: "+ technician_itr.getaddress());
					System.out.println("contactNo: "+ technician_itr.getcontactNo());
					System.out.println("---------------------------------------------");
				}
				
				break;
			default:
				System.out.println("Wrong Choice!");
				break;
			
			}
			System.out.println("Press 1 for the menu/0 to exit: ");
			loop_open=sc.nextInt();
		}while(loop_open==1);
		System.out.println("Program terminated...");
	}
	}

}
