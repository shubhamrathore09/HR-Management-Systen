package model;

public class Employee {
	private int emplId;
	private String name;
	private String address;
	private String email;
	private String password;
	
	
	public Employee() {
		super();
	}


	public Employee( String name, String address, String email, String password) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
//		this.JoinigDate = joinig_date;
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
