package spring.core.learning.tutorial.annotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;



@Component
@Lazy
public class Student {
	private String name;
	private String email;
	
	@Autowired
	private StudentAddress address;
	public Student() {}
	@PostConstruct
	public void postInit() {
		System.out.println("@PreConstruct");
	}
	
	public void inBetween() {
		System.out.println("Studying.....");
	}
	
	@PreDestroy
	public void preDelete() {
		System.out.println("@PreDestroy");
	}
	
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
