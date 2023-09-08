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

/**
 * The JobDAO class provides methods for interacting with the database to
 * perform various operations related to jobs.
 */
public class JobDAO {

	/**
	 * Creates a new job record in the database.
	 *
	 * @param job The Job object containing job information.
	 * @return true if the job creation was successful, false otherwise.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public boolean createJob(Job job) throws DAOException {
		String insertQuery = "INSERT INTO job (jobid, title, price, email) VALUES (?, ?, ?, ?)";

		// Get connection
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {

			String jobId = UUID.randomUUID().toString();

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

	/**
	 * Checks if a job with the specified email exists in the database.
	 *
	 * @param email The email to be checked.
	 * @return true if a job with the email exists, false otherwise.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public boolean checkEmail(String email) throws DAOException {
		String selectQuery = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
			statement.setString(1, email);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();

			boolean userExists = resultSet.next();

			resultSet.close();
			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves a job by its unique ID from the database.
	 *
	 * @param id The unique ID of the job to retrieve.
	 * @return The Job object corresponding to the provided ID.
	 * @throws DAOException If the job is not found or if there was an error during
	 *                      the database operation.
	 */
	public Job listJobs(String id) throws DAOException {
		List<Job> arr = new ArrayList<>();
		String selectQuery = "SELECT * FROM job WHERE jobid = ? AND isDeleted = false";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
			statement.setString(1, id);
			// Execute the query
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Job job = new Job();
				job.setJobid(resultSet.getString("jobid"));
				job.setTitle(resultSet.getString("title"));
				job.setPrice(resultSet.getInt("price"));
				arr.add(job);
			}
			resultSet.close();
			return arr.get(0);
		} catch (SQLException | IndexOutOfBoundsException e) {
			throw new DAOException("Job Not Found");
		}
	}

	/**
	 * Retrieves a list of jobs associated with a specific email address from the
	 * database.
	 *
	 * @param email The email address to filter jobs by.
	 * @return A list of Job objects associated with the provided email.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public List<Job> listJobsByEmail(String email) throws DAOException {
		List<Job> arr = new ArrayList<>();
		String selectQuery = "SELECT * FROM job WHERE email = ? AND isDeleted = false ORDER BY created_at";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
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
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return arr;
	}

	/**
	 * Updates the details of an existing job in the database.
	 *
	 * @param job The Job object containing updated job information.
	 * @return true if the job update was successful, false otherwise.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public boolean updateJob(Job job) throws DAOException {
		String updateQuery = "UPDATE job SET title = ?, price = ? WHERE jobid = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
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

	/**
	 * Marks a job as deleted in the database.
	 *
	 * @param jobId The unique ID of the job to mark as deleted.
	 * @return true if the job deletion was successful, false otherwise.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public boolean deleteJob(String jobId) throws DAOException {
		String updateQuery = "UPDATE job SET isDeleted = TRUE WHERE jobid = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
			statement.setString(1, jobId);
			// Execute the query
			int rows = statement.executeUpdate();
			// Return successful or not
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Checks if a job with the specified ID exists in the database.
	 *
	 * @param id The unique ID of the job to check.
	 * @return true if a job with the ID exists, false otherwise.
	 * @throws DAOException If there was an error during the database operation.
	 */
	public boolean checkJobId(String id) throws DAOException {
		String selectQuery = "SELECT jobid FROM job WHERE jobid = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {

			statement.setString(1, id);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();

			boolean userExists = resultSet.next();
			resultSet.close();
			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
