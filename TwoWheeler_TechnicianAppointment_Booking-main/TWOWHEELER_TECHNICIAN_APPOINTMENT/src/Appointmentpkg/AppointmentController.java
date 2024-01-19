package Appointmentpkg;

import java.util.List;
import java.util.Scanner;





public class AppointmentController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		String appointmentId,customerId,technicianId,serviceId,bike_no;

		AppointmentService appointmentService = new AppointmentServiceImpl();		//to call all methods through bikeDAO
		
	//to call all methods through bikeDAO
		
		int loop_open=1,choice;
		do
		{
			System.out.println("1. Enter Appointment ");
			System.out.println("2. Update Appointment");
			System.out.println("3. Delete Appointment ");
			System.out.println("4. View Appointment details by AppointmentID");
			System.out.println("5. View all Appointment details");
			System.out.println("9. Main Menu");
			System.out.println("0. Exit");
			System.out.println("Enter your choice= ");
			choice= sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter AppointmentId: ");
				appointmentId=sc.next();
				System.out.println("Enter CustomerId: ");
				customerId=sc.next();
				System.out.println("Enter ServiceId: ");
				serviceId=sc.next();
				System.out.println("Enter technicianId: ");
				technicianId=sc.next();
				System.out.println("Enter bikeNo: ");
				bike_no=sc.next();

				
				
				Appointment appointment1=new Appointment(appointmentId,customerId,serviceId,technicianId,bike_no);
				int records_inserted=appointmentService.addAppointment(appointment1);
				System.out.println("Total records inserted: "+records_inserted);
				break;
			case 2:
				System.out.println("Enter AppointmentId whose records to be updated: ");
				String old_appointmentId=sc.next();
				Appointment appointment2=appointmentService.getAppointmentById(old_appointmentId);
				if(appointment2==null)
					System.out.println("No records found");
				else{
					System.out.println("Enter appointmentId: ");
					appointmentId=sc.next();
					System.out.println("Enter CustomerId: ");
					customerId=sc.next();
					System.out.println("Enter serviceId: ");
					serviceId=sc.next();
					System.out.println("Enter technicianId: ");
					technicianId=sc.next();
					System.out.println("Enter Bike_NO: ");
					bike_no=sc.next();
					
					appointment2.setCustomer(customerId);
					appointment2.setCustomer(customerId);
					appointment2.setService(serviceId);
					appointment2.setTechnician(technicianId);
					appointment2.setBike(bike_no);
					
					int records_updated=appointmentService.updateAppointment(appointment2, old_appointmentId);
					System.out.println(records_updated+" Record updated");
				}
				break;
			case 3:
				System.out.println("Enter AppointmentId whose records to be deleted: ");
				appointmentId=sc.next();
				Appointment appointment3=appointmentService.getAppointmentById(appointmentId);
				if(appointment3==null)
					System.out.println("No records found");
				else
				{
					int records_deleted=appointmentService.deleteAppointment(appointment3);
					System.out.println(records_deleted+" Record deleted");
				}
				break;
			case 4:
				System.out.println("Enter AppoinmentId: ");
				appointmentId=sc.next();
				Appointment appointment4= appointmentService.getAppointmentById(appointmentId);
				if(appointment4==null)
					System.out.println("No records found");
				else
				{
					System.out.println("AppointmentId: "+ appointment4.getAppointementId());
					System.out.println("Customer: "+ appointment4.getCustomer().getCustomerId());
					System.out.println("Service: "+ appointment4.getService().getServiceId());
					System.out.println("Technician "+appointment4.getTechnician().getTechnicianId());
					System.out.println("Bike"+appointment4.getBike().getBike_no());
				}
				break;
			case 5:
				List<Appointment> appointments=appointmentService.allRecords();
				for(Appointment appointment_itr:appointments )
				{
					System.out.println("AppointmentId: "+ appointment_itr.getAppointementId());
					System.out.println("Customer: "+ appointment_itr.getCustomer().getCustomerId());
					System.out.println("Service: "+ appointment_itr.getService().getServiceId());
					System.out.println("Technician "+appointment_itr.getTechnician().getTechnicianId());
					System.out.println("Bike"+appointment_itr.getBike().getBike_no());				
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
