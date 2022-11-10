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
					System.out.println("Enter 1 to change password");
					int x=sc.nextInt();
					if(x==1) {
					EmployeeDao obj=new EmployeeDaoImpl();
					System.out.println(obj.changePassword(email));
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
	public static void main(String[] args) {
//		EmployeeOperations e1=new EmployeeOperations();
//		e1.EmployeeLogin();
	}
}
