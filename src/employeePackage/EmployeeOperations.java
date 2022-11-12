package employeePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import connectionWithDatabase.ConnectingDataBases;
import employeeDao.EmployeeDao;
import employeeDao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeOperations {
	public String EmployeeLogin() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee username");
		String email=sc.next();
		System.out.println("Enter employee password");
		String password=sc.next();
		String msg="user not found";
		String found=null;
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			PreparedStatement ps=con.prepareStatement("select name from employee where email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				found=rs.getString("name");
			
				System.out.println("welcome "+name);
				if(found!=null) {
					System.out.println("Enter 1 to perform operation of employee Enter 0 to exist");
					int operation=sc.nextInt();
					while(operation!=0) {
					System.out.println("Enter 1 to view detail of employee");
					System.out.println("Enter 2 to change password");
					System.out.println("Enter 3 to apply for leave");
					EmployeeDao e1=new EmployeeDaoImpl();
					int x=sc.nextInt();
					switch (x) {
					case 1: {
						Employee employee=new Employee();
						employee=e1.ViewEmployeeDetail(email);
						System.out.println("Name -"+employee.getName());
						System.out.println("Address -"+employee.getAddress());
						System.out.println("Email -"+employee.getEmail());
						System.out.println("Employee ID -"+employee.getEmplId());
						System.out.println("Employee Password -"+employee.getPassword());
						System.out.println("Department -"+employee.getDepartment());
						break;
					}
					case 2:{
						
						System.out.println(e1.changePassword(email));
						break;
					}
					case 3:{
						System.out.println("Please enter number of leave you want");
						int NumberOfLeave=sc.nextInt();
						System.out.println("Please enter your employeeId");
						int emplid=sc.nextInt();
						System.out.println(e1.ApplyLeave(emplid, NumberOfLeave));
						break;
					}
					default:
						
					}
					System.out.println("Enter 1 to perform operation of employee Enter 0 to exist");
					 operation=sc.nextInt();
				}
				}
			}
			
			else {
				System.out.println(msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();			
		}
		return msg;
	}
}
