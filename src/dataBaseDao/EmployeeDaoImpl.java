package dataBaseDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;

import connectionWithDatabase.ConnectingDataBases;
import model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String EmplRegistration(Employee employee) {
		
		String msg="Registration failed";
		
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			
			PreparedStatement ps=con.prepareStatement("insert into employee(name,address,email,password) values(?,?,?,?)");
			ps.setString(1,employee.getName());
			ps.setString(2,employee.getAddress());
			ps.setString(3,employee.getEmail());
			ps.setString(4,employee.getPassword());
			
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="succefully registor";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		
		return msg;
	}

	

	

}
