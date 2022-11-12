package adminDao;

import java.util.List;

import model.Department;
import model.Employee;

public interface AdminDao {
	public String addNewDepartment(Department department);
	public String transeferEmployee(int emplID,String department);
	public String employeeRegistration(Employee employee);
	public void ViewDepartment();
	public List<Employee> ViewEmployeeDetail();
	public String ProvideLeave();
}
