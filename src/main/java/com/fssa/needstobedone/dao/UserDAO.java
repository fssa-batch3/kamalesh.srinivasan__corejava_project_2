package com.fssa.needstobedone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.utils.ConnectionUtil;
import com.fssa.needstobedone.utils.ResultSetUtils;

/**
 * The UserDAO class provides methods for interacting with the database to
 * perform various operations related to users.
 */
public class UserDAO {

	/**
	 * Default constructor for UserDAO.
	 */
	public UserDAO() {
		// Default Constructor
	}

	/**
	 * Creates a new user record in the database.
	 *
	 * @param user The User object containing user information.
	 * @return true if the user creation was successful, false otherwise.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public boolean createUser(User user) throws DAOException {
		String query = "INSERT INTO users (email, password, firstname, lastname, isOwner) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFirstName());
			pst.setString(4, user.getLastName());
			pst.setBoolean(5, user.getisOwner());
			int rowsAffected = pst.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	/**
	 * Retrieves a user by their email from the database.
	 *
	 * @param email The email address of the user to retrieve.
	 * @return The User object corresponding to the provided email, or null if not
	 *         found.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public User getUserByEmail(String email) throws DAOException {
		User user = null;
		String query = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					System.out.println(rs.toString());
					user = ResultSetUtils.buildUserFromResultSet(rs);
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;
	}

	/**
	 * Checks if a user with the specified email exists in the database.
	 *
	 * @param email The email address to check.
	 * @return true if a user with the email exists, false otherwise.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public boolean checkUserByEmail(String email) throws DAOException {
		User user = null;
		String query = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					user = ResultSetUtils.buildUserFromResultSet(rs);
				}
			}
			return (user == null);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
