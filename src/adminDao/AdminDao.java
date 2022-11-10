package adminDao;

import model.Department;
import model.Employee;

public interface AdminDao {
	public String addNewDepartment(Department department);
	public String employeeRegistration(Employee employee);
	public void ViewDepartment();
}
