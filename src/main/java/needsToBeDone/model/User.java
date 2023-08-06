package needsToBeDone.model;

import java.time.LocalDate;

public class User {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private boolean isOwner;
	private LocalDate DOB;
	private long phoneNumber; 
	private long aadhar;
	private String address;
	


	public User(String email, String password, String firstName, String lastName, boolean isOwner,long phoneNumber,LocalDate DOB,long aadhar,String address) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isOwner = isOwner;
		this.DOB = DOB;
		this.phoneNumber = phoneNumber;
		this.aadhar = aadhar;
		this.address = address;
	}





	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public void setisOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public boolean getisOwner() {
		return isOwner;
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}
