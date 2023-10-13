package com.fssa.needstobedone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.model.AllModal;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.model.Notification;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.utils.ConnectionUtil;

public class JobDAO {

	public boolean createJob(Job job) throws DAOException {
	    String checkIfExistsQuery = "SELECT COUNT(*) FROM job WHERE title = ? AND location = ? AND price = ? AND description = ? AND summary = ? AND qualification = ? AND responsibilities = ?";
	    String insertQuery = "INSERT INTO job (jobid, title, location, price, description, summary, qualification, responsibilities, user_id) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement checkIfExistsStatement = connection.prepareStatement(checkIfExistsQuery);
	         PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

	        // Set parameters for checking if the record already exists
	        checkIfExistsStatement.setString(1, job.getTitle());
	        checkIfExistsStatement.setString(2, job.getLocation());
	        checkIfExistsStatement.setInt(3, job.getPrice());
	        checkIfExistsStatement.setString(4, job.getDescription());
	        checkIfExistsStatement.setString(5, job.getSummary());
	        checkIfExistsStatement.setString(6, job.getQualification());
	        checkIfExistsStatement.setString(7, job.getResponsibilities());

	        ResultSet resultSet = checkIfExistsStatement.executeQuery();
	        resultSet.next();
	        int count = resultSet.getInt(1);

	        // If a record with the same data already exists, return false
	        if (count > 0) {
	            throw new SQLException("Duplicate record");
	        }

	        // Data doesn't exist, proceed with the insertion
	        String jobId = UUID.randomUUID().toString();
	        insertStatement.setString(1, jobId);
	        insertStatement.setString(2, job.getTitle());
	        insertStatement.setString(3, job.getLocation());
	        insertStatement.setInt(4, job.getPrice());
	        insertStatement.setString(5, job.getDescription());
	        insertStatement.setString(6, job.getSummary());
	        insertStatement.setString(7, job.getQualification());
	        insertStatement.setString(8, job.getResponsibilities());
	        insertStatement.setInt(9, job.getUserId());

	        int rows = insertStatement.executeUpdate();
	        return (rows > 0);

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}

	public boolean updateJob(Job job) throws DAOException {
		String updateQuery = "UPDATE job SET title = ?, location = ?, price = ?, description = ?, "
				+ "summary = ?, qualification = ?, responsibilities = ?,status=? WHERE jobid = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setString(1, job.getTitle());
			statement.setString(2, job.getLocation());
			statement.setInt(3, job.getPrice());
			statement.setString(4, job.getDescription());
			statement.setString(5, job.getSummary());
			statement.setString(6, job.getQualification());
			statement.setString(7, job.getResponsibilities());
			statement.setString(9, job.getJobid());
			statement.setString(8, job.getStatus());
			int rows = statement.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Job> listJobs(String id) throws DAOException {
		List<Job> arr = new ArrayList<>();
		String selectQuery = "SELECT * FROM job WHERE user_id = ? AND isDeleted = false";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Job job = new Job();
				job.setJobid(resultSet.getString("jobid"));
				job.setTitle(resultSet.getString("title"));
				job.setPrice(resultSet.getInt("price"));
				job.setLocation(resultSet.getString("location"));
				job.setDescription(resultSet.getString("description"));
				job.setSummary(resultSet.getString("summary"));
				job.setQualification(resultSet.getString("qualification"));
				job.setResponsibilities(resultSet.getString("responsibilities"));
				job.setUserId(resultSet.getInt("user_id"));
				   String status = resultSet.getString("status");
				job.setStatus(resultSet.getString("status"));
				job.setCreatedDate(resultSet.getString("created_date"));
				arr.add(job);
			}
			resultSet.close();
			return arr;
		} catch (SQLException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new DAOException("Job Not Found");
		}
	}
	
	public List<Job> listJobsByJobId(String id) throws DAOException {
		List<Job> arr = new ArrayList<>();
		String selectQuery = "SELECT * FROM job WHERE jobid = ? AND isDeleted = false";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Job job = new Job();
				job.setJobid(resultSet.getString("jobid"));
				job.setTitle(resultSet.getString("title"));
				job.setPrice(resultSet.getInt("price"));
				job.setLocation(resultSet.getString("location"));
				job.setDescription(resultSet.getString("description"));
				job.setSummary(resultSet.getString("summary"));
				job.setQualification(resultSet.getString("qualification"));
				job.setResponsibilities(resultSet.getString("responsibilities"));
				job.setUserId(resultSet.getInt("user_id"));
				arr.add(job);
			}
			resultSet.close();
			return arr;
		} catch (SQLException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new DAOException("Job Not Found");
		}
	}

	public boolean deleteJob(String jobId) throws DAOException {
		String updateQuery = "UPDATE job SET isDeleted = TRUE WHERE jobid = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setString(1, jobId);
			int rows = statement.executeUpdate();
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
	
	public List<Job> listAllJobs() throws DAOException{
		List<Job> arr = new ArrayList<>();
		String selectQuery = "SELECT * FROM job where status != 'Started'";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Job job = new Job();
				job.setJobid(resultSet.getString("jobid"));
				job.setTitle(resultSet.getString("title"));
				job.setPrice(resultSet.getInt("price"));
				job.setLocation(resultSet.getString("location"));
				job.setDescription(resultSet.getString("description"));
				job.setSummary(resultSet.getString("summary"));
				job.setQualification(resultSet.getString("qualification"));
				job.setResponsibilities(resultSet.getString("responsibilities"));
				job.setUserId(resultSet.getInt("user_id"));
				job.setStatus(resultSet.getString("status"));
				arr.add(job);
			}
			resultSet.close();
			return arr;
		} catch (SQLException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new DAOException("Job Not Found");
		}
	}
	
	public List<AllModal> jobApplierList(String id) throws DAOException{
		List<AllModal> arr = new ArrayList<>();
		String selectQuery = "Select n.applier_id,n.status,n.job_id,u.user_id,u.firstName,u.lastName,u.email from notification n inner join users u on n.applier_id = u.user_id where n.job_id = ? ";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				AllModal jobList = new AllModal();
				Notification notification = new Notification();
				notification.setApplierId(resultSet.getInt("applier_id"));
				notification.setStatus(resultSet.getString("status"));
				User user = new User();
				user.setEmail(resultSet.getString("email"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				jobList.setNotification(notification);
				jobList.setUser(user);
				arr.add(jobList);
			}
			resultSet.close();
			return arr;
		} catch (SQLException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new DAOException("Job Not Found");
		}
	}
}
