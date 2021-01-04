package org.prac.models;

public class Employee {

	private String id;
	private String fName;
	private String lName;
	private String role;
	private String phoneNum;

	public Employee() {
		super();
	}

	public Employee(String id, String fName, String lName, String role, String phoneNum) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.role = role;
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", role=" + role + ", phoneNum="
				+ phoneNum + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public static class EmployeeBuilder {

		private String id;
		private String fName;
		private String lName;
		private String role;
		private String phoneNum;

		public EmployeeBuilder setId(String id) {
			this.id = id;
			return this;
		}

		public EmployeeBuilder setfName(String fName) {
			this.fName = fName;
			return this;
		}

		public EmployeeBuilder setlName(String lName) {
			this.lName = lName;
			return this;
		}

		public EmployeeBuilder setRole(String role) {
			this.role = role;
			return this;
		}

		public EmployeeBuilder setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
			return this;
		}

		public Employee build() {
			return new Employee(id, fName, lName, role, phoneNum);
		}
	}
}
