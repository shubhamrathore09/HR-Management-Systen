package employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import connectionWithDatabase.ConnectingDataBases;
import model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee ViewEmployeeDetail(String username) {
		Employee employee=null;
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			PreparedStatement ps=con.prepareStatement("select * from employee where email=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int emplID=rs.getInt("emplId");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String email=rs.getString("email");
				String password=rs.getString("password");
				String department=rs.getString("department");
				employee=new Employee(emplID, name, address, email, password, department);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return employee;
	}

	@Override
	public String changePassword(String email) {
		String msg="password not change";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter new password");
		
		String newpass=sc.next();
		 try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			PreparedStatement ps=con.prepareStatement("update employee set password= ? where email=?");
			ps.setString(1, newpass);
			ps.setString(2, email);
			int x=ps.executeUpdate();
			if(x>0) {
				
				msg="Password succefully changed";
			}
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		 
		return msg;
	}

	@Override
	public String ApplyLeave(int emplId,int numberOfleave) {
		String msg="Un-avail to apply";
		try(Connection con=ConnectingDataBases.DatabaseConnetion()) {
			PreparedStatement ps=con.prepareStatement("update employeeLeave set apply_eave=? where emplId=?");
			
			ps.setInt(1, numberOfleave);
			ps.setInt(2, emplId);
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="apply succesfully";
				System.out.println("asdf");
			}
		} catch (Exception e) {
			msg=e.getMessage();
			System.out.println("lkg");
		}
		return msg;
	}

}
