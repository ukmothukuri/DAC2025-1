package in.dac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String flat_house_no;
	private String State;
	private String district;
	private String city;
	private int pincode;
	
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flat_house_no=" + flat_house_no + ", State=" + State
				+ ", district=" + district + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	public Address() {
		
	}
	
	
	public String getFlat_house_no() {
		return flat_house_no;
	}
	public void setFlat_house_no(String flat_house_no) {
		this.flat_house_no = flat_house_no;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}	
}
