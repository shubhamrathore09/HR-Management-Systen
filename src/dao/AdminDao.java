package dao;

import java.util.List;

import bean.Department;
import bean.Employee;

public interface AdminDao {
	
	public String addNewDepartment(Department department);
	public String transeferEmployee(int emplID,String department);
	public String employeeRegistration(Employee employee);
	public void ViewDepartment();
	public List<Employee> ViewEmployeeDetail();
	public String ProvideLeave();

}
