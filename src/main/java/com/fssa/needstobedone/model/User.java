package com.fssa.needstobedone.model;

import java.time.LocalDate;

/**
 * The User class represents user-related data.
 */
public class User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isOwner;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private long aadhar;
    private String address;
    private int userId;

    /**
     * Constructs a new User with the specified user details.
     *
     * @param email       The user's email.
     * @param password    The user's password.
     * @param firstName   The user's first name.
     * @param lastName    The user's last name.
     * @param isOwner     A boolean indicating whether the user is an owner.
     * @param phoneNumber The user's phone number.
     * @param dateOfBirth The user's date of birth.
     * @param aadhar      The user's Aadhar number.
     * @param address     The user's address.
     */
    public User(String email, String password, String firstName, String lastName, boolean isOwner, long phoneNumber,
            LocalDate dateOfBirth, long aadhar, String address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isOwner = isOwner;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.aadhar = aadhar;
        this.address = address;
    }

    /**
     * Gets the user's date of birth.
     *
     * @return The user's date of birth.
     */
    public LocalDate getDOB() {
        return dateOfBirth;
    }

    /**
     * Sets the user's date of birth.
     *
     * @param dOB The user's date of birth to set.
     */
    public void setDOB(LocalDate dOB) {
        dateOfBirth = dOB;
    }

    /**
     * Sets whether the user is an owner.
     *
     * @param isOwner A boolean indicating whether the user is an owner.
     */
    public void setisOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    /**
     * Gets whether the user is an owner.
     *
     * @return true if the user is an owner, false otherwise.
     */
    public boolean getisOwner() {
        return isOwner;
    }

    /**
     * Constructs a new User with the specified email and password.
     *
     * @param email    The user's email.
     * @param password The user's password.
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Default constructor for the User class.
     */
    public User() {
    }

    /**
     * Sets the user's email.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user's password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's email.
     *
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the user's last name.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the user's phone number.
     *
     * @return The user's phone number.
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the user's Aadhar number.
     *
     * @return The user's Aadhar number.
     */
    public long getAadhar() {
        return aadhar;
    }

    /**
     * Gets the user's address.
     *
     * @return The user's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the user's address.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the user's Aadhar number.
     *
     * @param aadhar The Aadhar number to set.
     */
    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
                + ", isOwner=" + isOwner + ", DOB=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", aadhar=" + aadhar
                + ", address=" + address + ", userId=" + userId + "]";
    }
}
