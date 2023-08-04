package freshnest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import freshnest.DAO.exceptions.DAOException;
import freshnest.model.User;

public class UserDAO {

	// Connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freshnest", "root", "root");
		return connection;

	}

	// Get user from DB - Login
	public boolean checkUserLogin(String email, String password) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			String selectQuery = "SELECT * FROM user WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, email);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();

			boolean userExists = resultSet.next();

			if (userExists) {
				System.out.println("User present.");
				String storedPassword = resultSet.getString("password");
				if (storedPassword.equals(password)) {
					System.out.println("User successfully logged in.");
				} else {
					System.out.println("Incorrect password.");
				}
			} else {
				System.out.println("User credentials not exists.");
			}

			resultSet.close();
			statement.close();
			connection.close();

			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean createUser(User user) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO user (email,username, password, firstname, lastname) VALUES(?, ?,?, ? , ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
