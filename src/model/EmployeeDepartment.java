package model;

public class EmployeeDepartment {
	private String name;
	private String email;
	private String password;
	private String address;
	private String department;
	private int emplID;
	private int did;
	
	public EmployeeDepartment() {
		super();
	}

	public EmployeeDepartment(String name, String email, String password, String address, String department, int emplID,
			int did) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.department = department;
		this.emplID = emplID;
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmplID() {
		return emplID;
	}

	public void setEmplID(int emplID) {
		this.emplID = emplID;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}
	
	
	
}
