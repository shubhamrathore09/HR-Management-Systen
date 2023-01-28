package application;

import java.util.Scanner;

import bean.Department;
import bean.Employee;
import dao.AdminDao;
import dao.AdminDaoImpl;

public class InputFromUserForAdmin {
	
	
	Scanner sc=new Scanner(System.in);
	public String InputDepartment() {
		String msg="Adding failed";
		System.out.println("Enter Department Name");
		String dname=sc.next();
		System.out.println("Enter number of employee");
		int number=sc.nextInt();
		Department dept1=new Department( dname, number);
		AdminDao d2=new AdminDaoImpl();
		msg=d2.addNewDepartment(dept1);
		
	   return msg;
	}
	public String InputEmployee() {
		String msg="adding failed";
		System.out.println("Enter name of employee");
		String name=sc.next();
		System.out.println("Enter address of employee");
		String address=sc.next();
		System.out.println("Enter email of employee");
		String email=sc.next();
		System.out.println("Enter password of employee");
		String password=sc.next();
		System.out.println("Enter department of employee");
		String department=sc.next();
		Employee employee=new Employee(name, address, email, password, department);
		AdminDao emp=new AdminDaoImpl();
		msg=emp.employeeRegistration(employee);
		return msg;
	}
	public String ChnageEmployeeDepartment() {
		String msg="change faild";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter emplID");
		int empl=sc.nextInt();
		System.out.println("Enter Department name");
		String department=sc.next();
		
		AdminDao emp=new AdminDaoImpl();
		msg=emp.transeferEmployee(empl, department);
		return msg;
	}

}
