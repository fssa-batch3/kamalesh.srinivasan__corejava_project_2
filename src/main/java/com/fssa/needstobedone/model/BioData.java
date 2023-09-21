package com.fssa.needstobedone.model;
import java.sql.Date;

public class BioData {
    private String firstName;
    private String lastName;
    private Date dob;
    private String expertIn;
	private String phoneNumber;
    private String aadharNumber;
    private String upi;
    private String occupation;
    private String[] education;
    private String skills;
    private String address;
    private String comments;

    public BioData() {
        // Default constructor
    }

    public BioData(String firstName, String lastName, Date dob, String expertIn, String phoneNumber,
                   String aadharNumber, String upi, String occupation, String[] education, String skills,
                   String address, String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.expertIn = expertIn;
        this.phoneNumber = phoneNumber;
        this.aadharNumber = aadharNumber;
        this.upi = upi;
        this.occupation = occupation;
        this.education = education;
        this.skills = skills;
        this.address = address;
        this.comments = comments;
    }

    // Getters and setters for each field
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

    public String getExpertIn() {
        return expertIn;
    }

    public void setExpertIn(String expertIn) {
        this.expertIn = expertIn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String[] getEducation() {
        return education;
    }

    public void setEducation(String[] education) {
        this.education = education;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
