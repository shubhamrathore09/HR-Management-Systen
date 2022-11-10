package model;

public class Department {
	private int did;
	private String dname;
	private int numberOfEmployee;
	
	
	
	public Department() {
		super();
	}



	public Department(String dname, int numberOfEmployee) {
		super();
		this.dname = dname;
		this.numberOfEmployee = numberOfEmployee;
	}



	public Department(int did, String dname, int numberOfEmployee) {
		super();
		this.did = did;
		this.dname = dname;
		this.numberOfEmployee = numberOfEmployee;
	}



	public int getDid() {
		return did;
	}



	public void setDid(int did) {
		this.did = did;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}



	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	
}
