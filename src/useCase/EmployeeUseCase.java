package useCase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dataBaseDao.EmployeeDao;
import dataBaseDao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeUseCase {
	Scanner sc=new Scanner(System.in);
	public void insertEmpl() {
		System.out.println("Enter employee name");
		String name=sc.next();
		System.out.println("Enter employee Address");
		String address=sc.next();
		System.out.println("Enter employee email");
		String email=sc.next();
		System.out.println("Enter employee password");
		String password=sc.next();
		
		Employee employee=new Employee(name, address, email, password);
		EmployeeDao e1=new EmployeeDaoImpl();
		System.out.println(e1.EmplRegistration(employee));
		
	}
	

	
	
	
	public static void main(String[] args) {
		EmployeeUseCase obj=new EmployeeUseCase();
		obj.insertEmpl();

	
	}
	
}
