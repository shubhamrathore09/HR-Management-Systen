package useCase;

import java.util.Scanner;

import adminService.AdminOperations;
import employeeService.EmployeeOperations;

public class MainOperatingClass {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 login if you are admin");
		System.out.println("Enter 2 login if you are employee");
		int x=sc.nextInt();
		if(x==1) {
			AdminOperations obj=new AdminOperations();
		    obj.AdminLogin();
		    System.out.println("Done");
		}
		else if(x==2){
			EmployeeOperations obj=new EmployeeOperations();
			obj.EmployeeLogin();
			System.out.println("Done");
		}
		else {
			System.out.println("Wrong entry");
		}
		
	}
}
