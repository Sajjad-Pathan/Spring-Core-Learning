package spring.core.learning.tutorial.pojo;

public class Student {
	private String name;
	private String email;
	private StudentAddress address;

	public Student() {}
	
	public Student(String name, String email, StudentAddress address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public Student(String name, String email) {
		this.name = name;
		this.email = email;
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

	public StudentAddress getAddress() {
		return address;
	}

	public void setAddress(StudentAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
	

}
