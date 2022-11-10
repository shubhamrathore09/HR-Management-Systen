package employeeDao;

import model.Employee;

public interface EmployeeDao {
	public Employee ViewEmployeeDetail(String username);
	public String changePassword(String email);
	
}
