package technicianpkg;

import java.util.List;
import java.util.Scanner;



public class TechnicianController {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		String technicianId,name,address,contactNo;

		
		TechnicianService technicianService = new TechnicianServiceImpl();		//to call all methods through bikeDAO
		
		int loop_open=1,choice;
		do
		{
			System.out.println("1. Enter Technician ");
			System.out.println("2. Update Technician");
			System.out.println("3. Delete Technician ");
			System.out.println("4. View Technician details by TechnicianID");
			System.out.println("5. View all Technician details");
			System.out.println("9. Main Menu");
			System.out.println("0. Exit");
			System.out.println("Enter your choice= ");
			choice= sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter TechnicianId: ");
				technicianId=sc.next();
				sc.nextLine();
				System.out.println("Enter Name: ");
				name=sc.nextLine();
				System.out.println("Enter Address: ");
				address=sc.nextLine();
				System.out.println("Enter Contact no: ");
				contactNo=sc.nextLine();
				
				Technician technician1=new Technician(technicianId,name,address,contactNo);
				int records_inserted=technicianService.addTechnician(technician1);
				System.out.println("Total records inserted: "+records_inserted);
				break;
			case 2:
				System.out.println("Enter TechnicianId whose records to be updated: ");
				String old_technicianId=sc.next();
				Technician technician2=technicianService.getTechnicianById(old_technicianId);
				if(technician2==null)
					System.out.println("No records found");
				else{
					System.out.println("Enter technicianId: ");
					technicianId=sc.next();
					System.out.println("Enter name: ");
					name=sc.next();
					System.out.println("Enter address: ");
					address=sc.next();
					System.out.println("Enter Contact No: ");
					contactNo=sc.next();
					
					technician2.setTechnicianId(technicianId);
					technician2.setName(name);
					technician2.setAddress(address);
					technician2.setContactNo(contactNo);
					
					int records_updated=technicianService.updateTechnician(technician2, old_technicianId);
					System.out.println(records_updated+" Record updated");
				}
				break;
			case 3:
				System.out.println("Enter TechnicianId whose records to be deleted: ");
				technicianId=sc.next();
				Technician technician3=technicianService.getTechnicianById(technicianId);
				if(technician3==null)
					System.out.println("No records found");
				else
				{
					int records_deleted=technicianService.deleteTechnician(technician3);
					System.out.println(records_deleted+" Record deleted");
				}
				break;
			case 4:
				System.out.println("Enter TecnicianId: ");
				technicianId=sc.next();
				Technician technician4= technicianService.getTechnicianById(technicianId);
				if(technician4==null)
					System.out.println("No records found");
				else
				{
					System.out.println("TechnicianId: "+ technician4.getTechnicianId());
					System.out.println("Name: "+ technician4.getName());
					System.out.println("Address: "+ technician4.getAddress());
					System.out.println("Contact No"+technician4.getContactNo());
				}
				break;
			case 5:
				List<Technician> technicians=technicianService.allRecords();
				if(technicians==null)
					System.out.println("No records found");
				else{
				for(Technician technician_itr:technicians )
				{
					System.out.println("TechnicianId: "+ technician_itr.getTechnicianId());
					System.out.println("Model: "+ technician_itr.getName());
					System.out.println("Address: "+ technician_itr.getAddress());
					System.out.println("Contact No"+ technician_itr.getContactNo());
					System.out.println("---------------------------------------------");
				}
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

