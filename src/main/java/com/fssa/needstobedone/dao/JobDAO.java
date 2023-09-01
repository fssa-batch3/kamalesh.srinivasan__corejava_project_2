package com.fssa.needstobedone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.utils.ConnectionUtil;

public class JobDAO {

	public boolean createJob(Job job) throws DAOException {
		String insertQuery = "INSERT INTO job (jobid, title, price, email) VALUES (?, ?, ?, ?)";

		// Get connection
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {

			String jobId = UUID.randomUUID().toString();
			System.out.println(jobId);
			System.out.println(job.getEmail());

			// Prepare SQL statement

			statement.setString(1, jobId);
			statement.setString(2, job.getTitle());
			statement.setInt(3, job.getPrice());
			statement.setString(4, job.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows > 0);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

//	check the job is present in the job table 
	public boolean checkEmail(String email) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			String selectQuery = "SELECT * FROM users WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, email);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();

			boolean userExists = resultSet.next();

			resultSet.close();
			statement.close();
			connection.close();

			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Job> listJobs(String id) throws DAOException {
		List<Job> arr = new ArrayList<>();
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			String selectQuery = "SELECT * FROM job WHERE jobid = ? AND isDeleted = false";
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, id);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Job job = new Job();
				job.setJobid(resultSet.getString("jobid"));
				job.setEmail(resultSet.getString("title"));
				job.setPrice(resultSet.getInt("price"));
				arr.add(job);
			}

			resultSet.close();
			statement.close();
			connection.close();

//			Return the job list 

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return arr;

	}
	
	
	public List<Job> listJobsByEmail(String email) throws DAOException {
		List<Job> arr = new ArrayList<>();
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			String selectQuery = "SELECT * FROM job WHERE email = ? AND isDeleted = false ORDER BY created_at";
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, email);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Job job = new Job();
				job.setJobid(resultSet.getString("jobid"));
				job.setTitle(resultSet.getString("title"));
				job.setPrice(resultSet.getInt("price"));
				job.setEmail(resultSet.getString("email"));
				job.setIsDeleted(resultSet.getBoolean("isDeleted"));
				arr.add(job);
			}

			resultSet.close();
			statement.close();
			connection.close();

//			Return the job list 

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return arr;

	}

	public boolean updateJob(Job job) throws DAOException {

		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String updateQuery = "UPDATE job SET title = ?, price = ? WHERE jobid = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setString(1, job.getTitle());
			statement.setInt(2, job.getPrice());
			statement.setString(3, job.getJobid());
			// Execute the query
			int rows = statement.executeUpdate();
			// Return successful or not
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean deleteJob(String jobId) throws DAOException {

		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String updateQuery = "UPDATE job SET isDeleted = TRUE WHERE jobid = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setString(1, jobId);
			// Execute the query
			int rows = statement.executeUpdate();
			// Return successful or not
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean checkJobId(String id) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			String selectQuery = "SELECT jobid FROM job WHERE jobid = ?";
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, id);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();

			boolean userExists = resultSet.next();
			resultSet.close();
			statement.close();
			connection.close();

			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
