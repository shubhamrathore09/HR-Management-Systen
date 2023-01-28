package application;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import application.*;
import bean.Employee;
import dao.AdminDao;
import dao.AdminDaoImpl;
import utility.ConnectingDataBases;

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
					System.out.println("Press 1 to perform operation on employee table press 0 to exist");
					int num=sc.nextInt();
					while(num!=0) {
					System.out.println("press 1 to add new department");
					System.out.println("press 2 to insert into nem employee");
					System.out.println("press 3 to view department Details");
					System.out.println("press 4 to transfer employee in other department");
					System.out.println("press 5 to view employee details");
					System.out.println("Press 6 to provide leave to employee");
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
					case 4:{
						
						InputFromUserForAdmin obj=new InputFromUserForAdmin();
						System.out.println(obj.ChnageEmployeeDepartment());
						break;
						
					}
					case 5:{
						AdminDao obj=new AdminDaoImpl();
					List<Employee> list=	obj.ViewEmployeeDetail();
					for(Employee e1:list) {
						System.out.println("Employee name :-"+e1.getName());
						System.out.println("Employee Email :-"+e1.getEmail());
						System.out.println("Employee EmplId :-"+e1.getEmplId());
						System.out.println("Employee department :-"+e1.getDepartment());
						System.out.println("Employee address :-"+e1.getAddress());
						System.out.println("------------------------------------------------------");
						
					}
					break;
					}
					case 6:{
						AdminDao obj=new AdminDaoImpl();
						
						System.out.println(obj.ProvideLeave());
						break;
					}
					default:
						System.out.println("invalid entry");
					}
					System.out.println("Press 1 to perform operation on employee table press 0 to exist");
					num=sc.nextInt();
					
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
