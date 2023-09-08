package com.fssa.needstobedone.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.needstobedone.model.User;

/**
 * Utility class for building User objects from ResultSet data.
 */
public class ResultSetUtils {

	// Private constructor to prevent instantiation
	private ResultSetUtils() {
		// Do nothing (empty constructor)
	}

	/**
	 * Builds a User object from the data in a ResultSet.
	 *
	 * @param rs The ResultSet containing user data.
	 * @return A User object populated with data from the ResultSet.
	 * @throws SQLException If a database access error occurs.
	 */
	public static User buildUserFromResultSet(ResultSet rs) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("firstname"));
		user.setLastName(rs.getString("lastname"));
		user.setisOwner(rs.getBoolean("isOwner"));
		user.setPhoneNumber(rs.getLong("phone_number"));
		user.setDOB(rs.getDate("dob").toLocalDate());
		user.setAddress(rs.getString("address"));
		return user;
	}
}
