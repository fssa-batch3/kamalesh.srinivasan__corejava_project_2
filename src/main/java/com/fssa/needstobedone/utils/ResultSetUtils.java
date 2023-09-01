package com.fssa.needstobedone.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.needstobedone.model.User;

public class ResultSetUtils {
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
