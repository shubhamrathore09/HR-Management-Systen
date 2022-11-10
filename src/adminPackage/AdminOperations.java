package adminPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import adminDao.AdminDao;
import adminDao.AdminDaoImpl;
import adminInputFromUser.InputFromUserForAdmin;
import connectionWithDatabase.ConnectingDataBases;
import model.Department;

public class AdminOperations {
	public void AdminLogin() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		String found=null;
		
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			
			PreparedStatement ps=con.prepareStatement("select adminname from admin where adminUserName=? AND adminPassword=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				found=rs.getString("adminname");
				if(found!=null) {
					System.out.println("welcome "+found);
					
					System.out.println("press 1 to add new department");
					System.out.println("press 2 to insert into nem employee");
					System.out.println("press 3 to view employee Details");
					
					int x=sc.nextInt();
					switch (x) {
					case 1: {
						InputFromUserForAdmin obj=new InputFromUserForAdmin();
						System.out.println(obj.InputDepartment());
						break;
					}
					case 2:{
						InputFromUserForAdmin obj=new InputFromUserForAdmin();
						System.out.println(obj.InputEmployee());
						break;
					}
					case 3:{
						AdminDao obj=new AdminDaoImpl();
					    obj.ViewDepartment();
					    break;
					}
					default:
						System.out.println("invalid entry");
					}
					
				}
			
				
				
				
				
			}
			else {
				System.out.println("username not found");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
