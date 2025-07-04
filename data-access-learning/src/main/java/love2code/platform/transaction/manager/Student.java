package love2code.platform.transaction.manager;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
	private String name;
	private String number;

	public Student() {
	}

	public Student(int id, String name, String number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", number=" + number + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
