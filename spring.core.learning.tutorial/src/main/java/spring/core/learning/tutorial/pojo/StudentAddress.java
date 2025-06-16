package spring.core.learning.tutorial.pojo;

import java.util.List;

public class StudentAddress {
	private String streetName;
	private String city;
	private String state;

	private List<String> list;
	
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public StudentAddress(List<String> list) {
		this.list = list;
	}

	public StudentAddress(String streetName, String city, String state) {
		this.streetName = streetName;
		this.city = city;
		this.state = state;
	}
	
	public StudentAddress() {}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "StudentAddress [streetName=" + streetName + ", city=" + city + ", state=" + state + "]";
	}

}
