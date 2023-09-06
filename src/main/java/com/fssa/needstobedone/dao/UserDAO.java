package com.fssa.needstobedone.dao;

import static com.fssa.needstobedone.utils.ResultSetUtils.buildUserFromResultSet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.utils.ConnectionUtil;;

public class UserDAO {

	public UserDAO() {
	}

	public boolean createUser(User user) throws DAOException {
		String query = "INSERT INTO users (email, password, firstname, lastname, isOwner, phone_number, dob, address,aadhar) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFirstName());
			pst.setString(4, user.getLastName());  
			pst.setBoolean(5, user.getisOwner());
			pst.setLong(6, user.getPhoneNumber());
			pst.setDate(7, Date.valueOf(user.getDOB()));
			pst.setString(8, user.getAddress());
			pst.setLong(9, user.getAadhar());

			int rowsAffected = pst.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public User getUserByEmail(String email) throws DAOException {
		User user = null;
		String query = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					user = buildUserFromResultSet(rs);
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;
	}

	public boolean checkUserByEmail(String email) throws DAOException {
		User user = null;
		String query = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					user = buildUserFromResultSet(rs);
				}
			}
			if (user == null) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}


}
