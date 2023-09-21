package com.fssa.needstobedone.model;

/**
 * The User class represents user-related data.
 */
public class User {

	private String email;
	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	private String password;
	private String firstName;
	private String lastName;
	private boolean isOwner;
	private int userId;

	/**
	 * Constructs a new User with the specified user details.
	 *
	 * @param email       The user's email.
	 * @param password    The user's password.
	 * @param firstName   The user's first name.
	 * @param lastName    The user's last name.
	 * @param isOwner     A boolean indicating whether the user is an owner.
	 */
	public User(String email, String password, String firstName, String lastName, boolean isOwner) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isOwner = isOwner;
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

	

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", isOwner=" + isOwner + ", DOB=" + ", userId=" + userId + "]";
	}

}
