package freshnest.model;

public class User {

	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public User(String email, String username, String password, String firstName, String lastName) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getUsername() {
		return username;
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

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + "]";
	}

}
