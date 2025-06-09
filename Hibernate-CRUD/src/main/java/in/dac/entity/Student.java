package in.dac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "rollnumber")
	private int id;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "passed_out_year")
	private int yearofpassing;
	
	private String branch;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearofpassing() {
		return yearofpassing;
	}

	public void setYearofpassing(int yearofpassing) {
		this.yearofpassing = yearofpassing;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", yearofpassing=" + yearofpassing + ", branch=" + branch + "]";
	}
	
	
}
