package in.dac.utils;

public class Validations {
	public boolean isUserNameValid(String name) {
		if(name.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean isUserEmailValid(String email) {
		if(email.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean isUserMobileValid(String mobile) {
		if(mobile.isEmpty()) {
			return false;
		} else if(mobile.length() != 10) {
			return false;
		}
		return true;
	}
	
	public boolean isUserPasswordValid(String password) {
		if(password.isEmpty()) {
			return false;
		} else if(password.length() <8) {
			return false;
		}
		return true;
		
		
	}
}
