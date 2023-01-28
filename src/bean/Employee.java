package bean;

public class Employee {
	private int emplId;
	private String name;
	private String address;
	private String email;
	private String password;
	private String department;
	
	public Employee() {
		super();
	}
	
	


	public Employee(int emplId, String name, String address, String email, String department) {
		super();
		this.emplId = emplId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.department = department;
	}




	public Employee(String name, String address, String email, String password,String department) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.department=department;
	}


	public Employee(int id, String name, String address, String email, String password,String department) {
		super();
		this.emplId=id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.department=department;
//		this.JoinigDate = joinig_date;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getEmplId() {
		return emplId;
	}


	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


//	public int getJoinigDate() {
//		return JoinigDate;
//	}
//
//
//	public void setJoinigDate(int joinigDate) {
//		JoinigDate = joinigDate;
//	}


	
	
	
}
