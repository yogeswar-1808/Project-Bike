package servicepkg;

import java.util.List;
import java.util.Scanner;

public class ControllerService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean loop=true;
		while(loop){
			System.out.println("SERVICES");
			System.out.println("1. Enter a Repairing Service");
			System.out.println("2. Modify Repairing Service Details");
			System.out.println("3. Delete repairing service record");
			System.out.println("4. View single record");
			System.out.println("5. View all records");
			System.out.println("9. Main Menu");
			System.out.println("0. Exit");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice){
			case 1:
				ServiceServiceClassImplementation servicedao = new ServiceServiceClassImplementation();
				System.out.println("Enter ServiceId : ");
				String serviceId = sc.next();
				System.out.println("Enter Servicing Details : ");
				String desc = sc.next();
				System.out.println("Enter Cost : ");
				int cost = sc.nextInt();
				Service service = new Service(serviceId, desc, cost);
				int result = servicedao.addService(service);
				System.out.println(result);
				System.out.println("Service Entered in Database");
				break;
			case 2:
				ServiceServiceClassImplementation servicedao2= new ServiceServiceClassImplementation();
				System.out.println("Enter ServiceId to be updated : ");
				String serviceId2 = sc.next();
				System.out.println("Enter new Service Id");
				String newservice2 = sc.next();
				System.out.println("Enter Servicing Details : ");
				String desc2 = sc.next();
				System.out.println("Enter Cost : ");
				int cost2 = sc.nextInt();
				Service service2 = new Service(newservice2, desc2, cost2);
				int result2 = servicedao2.modifyService(service2, serviceId2);
				System.out.println(result2);
				System.out.println("Service Modifyied in Database");
				break;
			case 3:
				ServiceServiceClassImplementation servicedao3 = new ServiceServiceClassImplementation();
				System.out.println("Enter ServiceId you want to delete : ");
				String serviceid3 = sc.next();
				Service service3 = servicedao3.viewSingleRecord(serviceid3);
				System.out.println("Record you want to delete");
				System.out.println("ServiceId : " + service3.getServiceId());
				System.out.println("Servicing Details : " + service3.getDescription());
				System.out.println("Cost : " + service3.getCharges());
				System.out.println("To Confirm press y");
				char confirm = sc.next().charAt(0);
				if(confirm == 'y'){
					@SuppressWarnings("unused")
					int res = servicedao3.deleteService(service3);
					System.out.println("Record Deleted Successfully");
				}else{
					System.out.println("Record Not Deleted");
				}
				break;
			case 4:
				ServiceServiceClassImplementation servicedao4 = new ServiceServiceClassImplementation();
				System.out.println("Enter ServiceId you want to view : ");
				String serviceid4 = sc.next();
				Service service4 = servicedao4.viewSingleRecord(serviceid4);
				System.out.println("ServiceId : " + service4.getServiceId());
				System.out.println("Servicing Details : " + service4.getDescription());
				System.out.println("Cost : " + service4.getCharges());
				break;
			case 5:
				ServiceServiceClassImplementation servicedao5 = new ServiceServiceClassImplementation();
				List<Service> services=servicedao5.getAllService();
				for(Service service_itr: services)
				{
					System.out.println("ServiceId"+ service_itr.getServiceId());
					System.out.println("Servicing Details : "+ service_itr.getDescription());
					System.out.println("Cost : "+ service_itr.getCharges());
					System.out.println("---------------------------------------------");
				}
				break;
			case 9: return;
			case 0:System.out.println("Exiting...");
					System.exit(0);
			default:
				System.out.println("Wrong Choice!");
				break;			}

			
			
		}



	}

}
