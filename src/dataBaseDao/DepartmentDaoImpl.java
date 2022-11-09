package dataBaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connectionWithDatabase.ConnectingDataBases;
import model.Department;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public String InsertIntoDepartment(Department department) {
		
		String msg="Not update";
		
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			
			PreparedStatement ps=con.prepareStatement("insert into department(dname,numberOfEmployee) values(?,?)");
			ps.setString(1, department.getDname());
			ps.setInt(2, department.getNumberOfEmployee());
			int x=ps.executeUpdate();
			if(x>0) {
				msg="new department added";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		
		return msg;
	}

}
