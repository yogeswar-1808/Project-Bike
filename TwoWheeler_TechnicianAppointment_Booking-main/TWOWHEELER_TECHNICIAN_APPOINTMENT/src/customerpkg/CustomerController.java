package customerpkg;

import java.util.List;
import java.util.Scanner;

import customerpkg.Customer;


public class CustomerController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		String customerId,name,address,contactNo;

		
		CustomerService customerService = new CustomerServiceImpl();		//to call all methods through bikeDAO
		
		int loop_open=1,choice;
		do
		{
			System.out.println("1. Enter Customer ");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete Customer ");
			System.out.println("4. View Customer details by CustomerID");
			System.out.println("5. View all Customer details");
			System.out.println("9. Main Menu");
			System.out.println("0. Exit");
			System.out.println("Enter your choice= ");
			choice= sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter CustomerId: ");
				customerId=sc.next();
				sc.nextLine();
				System.out.println("Enter Name: ");
				name=sc.nextLine();
				System.out.println("Enter Address: ");
				address=sc.nextLine();
				System.out.println("Enter Contact no: ");
				contactNo=sc.nextLine();
				
				Customer customer1=new Customer(customerId,name,address,contactNo);
				int records_inserted=customerService.insert(customer1);
				System.out.println("Total records inserted: "+records_inserted);
				break;
			case 2:
				System.out.println("Enter CustomerId whose records to be updated: ");
				String old_customerId=sc.next();
				Customer customer2=customerService.viewSingleRecord(old_customerId);
				if(customer2==null)
					System.out.println("No records found");
				else
					System.out.println("Enter customerId: ");
					customerId=sc.next();
					System.out.println("Enter name: ");
					name=sc.next();
					System.out.println("Enter address: ");
					address=sc.next();
					System.out.println("Enter Contact No: ");
					contactNo=sc.next();
					
					customer2.setCustomerId(customerId);
					customer2.setName(name);
					customer2.setAddress(address);
					customer2.setContact(contactNo);
					
					int records_updated=customerService.update(customer2, old_customerId);
					System.out.println(records_updated+" Record updated");
				break;
			case 3:
				System.out.println("Enter CustomerId whose records to be deleted: ");
				customerId=sc.next();
				Customer customer3=customerService.viewSingleRecord(customerId);
				if(customer3==null)
					System.out.println("No records found");
				else
				{
					int records_deleted=customerService.delete(customer3);
					System.out.println(records_deleted+" Record deleted");
				}
				break;
			case 4:
				System.out.println("Enter CustomerId: ");
				customerId=sc.next();
				Customer customer4= customerService.viewSingleRecord(customerId);
				if(customer4==null)
					System.out.println("No records found");
				else
				{
					System.out.println("CustomerId: "+ customer4.getCustomerId());
					System.out.println("Name: "+ customer4.getName());
					System.out.println("Address: "+ customer4.getAddress());
					System.out.println("Contact No"+customer4.getContact());
				}
				break;
			case 5:
				List<Customer> customers=customerService.getAllCustomer();
				for(Customer customer_itr:customers )
				{
					System.out.println("CustomerId: "+ customer_itr.getCustomerId());
					System.out.println("Name: "+ customer_itr.getName());
					System.out.println("Address: "+ customer_itr.getAddress());
					System.out.println("Contact No"+ customer_itr.getContact());
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
