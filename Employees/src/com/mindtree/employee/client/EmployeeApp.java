package com.mindtree.employee.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.employee.entity.Employee;
import com.mindtree.employee.service.EmployeeService;
import com.mindtree.employee.service.impl.EmployeeServiceImpl;


public class EmployeeApp {
	static EmployeeService service=new EmployeeServiceImpl();
	static Scanner sc=new Scanner(System.in);
	List<Employee> list=new ArrayList();
	public static void main(String[] args) throws Exception {
		System.out.println("*******************WELCOME***********************");
		int choice=0;
		do {System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Enter your choice: ");
			displayMenu();
			choice=sc.nextInt();
			switch(choice) {
			case 1:// Insert employee
					insertToDB();
					break;
				
			case 2:// Delete employee
					deleteFromDB();
					break;
			
			case 3:// Update employee phone number
					updatePhoneNumber();
					break;
			
			case 4:// Get List of campus minds
					getAllCampusMinds();
					break;
					
			default:System.out.println("Invalid choice");
					break;
			}
		}while(choice!=5);
	}
	
	private static void deleteFromDB() throws Exception {
		boolean isDeleted=false;
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		//try {
			isDeleted=service.deleteEmployeeFromDB(id);
	//	}
		//catch (EmployeeServiceException e) {
			//System.out.println(e.getLocalizedMessage());
		//}
		if (isDeleted) {
			System.out.println("Employee deleted successfully");
		} else {
			System.out.println("something went wrong..");
		}
		
	}

	private static void getAllCampusMinds() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			list = service.getAllCampusMindsFromDB();
		} catch (Exception e) {
		System.out.println("Something went wrong");
		}
		displayEmployeeFromDB(list);
	}

	private static void updatePhoneNumber() {
		boolean isUpdated=false;
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		System.out.println("Enter phone number");
		sc.nextLine();
		String phone=sc.next();
		try {
			isUpdated=service.updatePhoneInDB(id, phone);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		if (isUpdated) {
			System.out.println("Phone Number updated successfully");
		} else {
			System.out.println("something went wrong..");
		}
	}
		
	private static void displayEmployeeFromDB(List<Employee> list2) {
		for (Employee employee : list2) {
			System.out.println(employee.getEmpId() + " " + employee.getEmpName() + " " + employee.getPhone()+ " " + employee.getTrackName()+ " " + employee.getRole());
		}
	}

	

	private static void insertToDB() throws Exception {
		boolean isInserted=false;
		Employee emp=createEmployee(); 
		try {
			isInserted=service.insertIntoDB(emp);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		if (isInserted) {
			System.out.println("Employee inserted successfully");
		} else {
			System.out.println("something went wrong..");
		}
		}


	private static Employee createEmployee() throws Exception {
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		System.out.println("Enter name");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter track name");
		System.out.println(">>>1.Java");
		System.out.println(">>>2.Sdet");
		System.out.println(">>>3.Dotnet");
		System.out.println(">>>4.DevOps");
		System.out.println(">>>5.Python");
		int trackNum=sc.nextInt();
		String trackName=service.getTrackName(trackNum);
		System.out.println("Enter phone number");
		sc.nextLine();
		String phone=sc.next();
		System.out.println("Enter role:");
		System.out.println(">>> 1.Lead");
		System.out.println(">>> 2.Campus Mind");
		int roleNum=sc.nextInt();
		String role=service.getRole(roleNum);
		Employee emp=new Employee(id,name,trackName,phone,role);
		return emp;
	}

	

	private static void displayMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. Insert employee details into database");
		System.out.println("2. Delete employee details from database");
		System.out.println("3. Update employee phone number in the database");
		System.out.println("4. Get the campus minds list in specific track");
		System.out.println("5. Exit");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}

}
