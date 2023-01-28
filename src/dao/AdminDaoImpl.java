package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Department;
import bean.Employee;
import utility.ConnectingDataBases;

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
				
				PreparedStatement PsForLeave=con.prepareStatement("select emplId from employee where email=?");
				
				PsForLeave.setString(1, employee.getEmail());
				
				ResultSet RsForLeave=PsForLeave.executeQuery();

				if(RsForLeave.next()) {
					int emplId=RsForLeave.getInt("emplId");
					PreparedStatement psForinsertIntoEmployeeLeave =con.prepareStatement("insert into EmployeeLeave values(?,?,?,?)");
					psForinsertIntoEmployeeLeave.setInt(1, emplId);
					psForinsertIntoEmployeeLeave.setInt(2, 24);
					psForinsertIntoEmployeeLeave.setInt(3, 0);
					psForinsertIntoEmployeeLeave.setInt(4, 0);
					psForinsertIntoEmployeeLeave.executeUpdate();
				}
				PreparedStatement ps1=con.prepareStatement("select NumberOfEmployee from department where dname=?");
				ps1.setString(1, employee.getDepartment());
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next()) {
					int data=rs1.getInt(1);
					data++;
					PreparedStatement ps3=con.prepareStatement("update department set NumberOfEmployee=? where dname=?");
					ps3.setInt(1, data);
					ps3.setString(2, employee.getDepartment());
					ps3.executeUpdate();
				}
				
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



	@Override
	public String transeferEmployee(int emplID,String department) {
		int EmployeeNumber=0;
		String msg="Transfor failed";
		try (Connection con=ConnectingDataBases.DatabaseConnetion()){
			
			PreparedStatement ps=con.prepareStatement("select department from employee where emplId=?");
			ps.setInt(1, emplID);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				String dname=rs.getString("department");
				
				PreparedStatement ps1=con.prepareStatement("select NumberOfEmployee from department where dname=?");
				
				ps1.setString(1,dname);
				
				ResultSet rs1=ps1.executeQuery();
				
				if(rs1.next()) {
				EmployeeNumber=	rs1.getInt("NumberOfEmployee");	
				if(EmployeeNumber>0) {
					EmployeeNumber=EmployeeNumber-1;
					
					PreparedStatement ps2=con.prepareStatement("update department set NumberOfEmployee=? where dname=?");
					ps2.setInt(1, EmployeeNumber);
					ps2.setString(2, dname);
					ps2.executeUpdate();
					
					PreparedStatement ps3=con.prepareStatement("update employee set department=? where emplID=?");
					ps3.setString(1, department);
					ps3.setInt(2, emplID);
					int x=ps3.executeUpdate();
					
					if(x>0) {
						PreparedStatement ps4=con.prepareStatement("select NumberOfEmployee from department where dname=?");
						ps4.setString(1,department);
						
						ResultSet rs2=ps4.executeQuery();
						
						if(rs2.next()) {
							int currentEmployeeNum=rs2.getInt("NumberOfEmployee");
							currentEmployeeNum++;
							PreparedStatement ps5=con.prepareStatement("update department set NumberOfEmployee=? where dname=?");
							ps5.setInt(1, currentEmployeeNum);
							ps5.setString(2, department);
							ps5.executeUpdate();
							msg="Transefer done succesfully";
						}
					}
					
				}
			  }
			}
			
	
		
			else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		
		return msg;
	}

	@Override
	public List<Employee> ViewEmployeeDetail() {
		List<Employee> list=new ArrayList<>();
		
		try(Connection con=ConnectingDataBases.DatabaseConnetion()) {
			
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("emplID");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String email=rs.getString("email");
				String department=rs.getString("department");
				Employee employee=new Employee(id, name, address, email, department);
				list.add(employee);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return list;
	}

	@Override
	public String ProvideLeave() {
		String msg="Leave not provided";
		
		try ( Connection con=ConnectingDataBases.DatabaseConnetion()){
			PreparedStatement ps=con.prepareStatement("select * from employeeLeave where apply_eave>?");
			ps.setInt(1, 0);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int applyleave=rs.getInt("apply_eave");
				int available_leave=rs.getInt("available_leave");
			int emplId=rs.getInt("emplId");
				if(available_leave>=applyleave) {
					int provide=applyleave;
					
					int remainleave=available_leave-applyleave;
					
				   applyleave=applyleave-applyleave;
					PreparedStatement ps1=con.prepareStatement("update employeeleave set available_leave=?, apply_eave=?, Last_Approved_eave=? where emplId=?");
					ps1.setInt(1, remainleave);
					ps1.setInt(2, applyleave);
					ps1.setInt(3, provide);
					ps1.setInt(4,emplId);
					int x=ps1.executeUpdate();
					if(x>0) {
						msg="Leave provided";
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		
		return msg;
	}


}
