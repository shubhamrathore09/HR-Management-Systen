package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import adminInputFromUser.InputFromUserForAdmin;
import connectionWithDatabase.ConnectingDataBases;
import model.Department;
import model.Employee;

public class AdminDaoImpl implements AdminDao{

	@Override
	public  String addNewDepartment(Department department) {
		String msg="Department adding failed";
//		InputFromUserForAdmin d1=new InputFromUserForAdmin();
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			PreparedStatement ps=con.prepareStatement("insert into department(dname,NumberOfEmployee) values(?,?)");
			ps.setString(1, department.getDname());
			ps.setInt(2, department.getNumberOfEmployee());
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Department added succefully";
			}
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		return msg;
	}

	@Override
	public String employeeRegistration(Employee employee) {
		String msg="Registration failed";
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			
			PreparedStatement ps=con.prepareStatement("insert into employee(name,address,email,password,department) values(?,?,?,?,?)");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getPassword());
			ps.setString(5, employee.getDepartment());
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Registration done succesfully";
			}
			
		} catch (Exception e) {
			msg=e.getMessage();
			// TODO: handle exception
		}
		return msg;
	}

	@Override
	public void ViewDepartment() {
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			PreparedStatement ps=con.prepareStatement("select * from department");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int did=rs.getInt("did");
				String dname=rs.getString("dname");
				int emp=rs.getInt("NumberOfEmployee");
				System.out.println("Department id "+did +" department Name "+dname+" Number of employee "+emp);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		};
		
	}

}
