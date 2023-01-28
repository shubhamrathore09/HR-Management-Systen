package dao;

import bean.Employee;

public interface EmployeeDao {
	public Employee ViewEmployeeDetail(String username);
	public String changePassword(String email);
	public String ApplyLeave(int emplId,int NumberOfLeave);
}
