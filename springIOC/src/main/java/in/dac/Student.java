package in.dac;

public class Student
{
	private String name;
	private String email;
	private Address ads;
	
	public Student() {
	}
	
	public Address getAds() {
		return ads;
	}

	public void setAds(Address ads) {
		this.ads = ads;
	}

	public Student(Address ads) {		
		this.ads = ads;
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
	public void display() {
		System.out.print("Welcome to Spring");
	}
}
