package com.fssa.needstobedone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.model.AllModal;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.model.Notification;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.utils.ConnectionUtil;

public class NotificationDAO {
	public boolean createNotification(Notification notification) throws DAOException {
		String insertQuery = "INSERT INTO notification (applier_id, job_id, status) VALUES (?, ?, ?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			statement.setInt(1, notification.getApplierId());
			statement.setString(2, notification.getJobId());
			statement.setString(3, notification.getStatus());
			int rows = statement.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Notification Not Created becausae of " + e.getMessage());
		}
	}

	public List<AllModal> getNotificationsByApplierId(int applierId) throws DAOException {
		List<AllModal> notifications = new ArrayList<>();

		String sql = "SELECT n.notification_id, n.applier_id, n.job_id, n.status, "
				+ "j.title, j.description, j.location, u.firstname, u.lastname,u.email " + "FROM notification n "
				+ "INNER JOIN job j ON n.job_id = j.jobid " + "INNER JOIN users u ON j.user_id = u.user_id "
				+ "WHERE n.applier_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, applierId);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Notification notification = new Notification();
					notification.setApplierId(resultSet.getInt("applier_id"));
					notification.setJobId(resultSet.getString("job_id"));
					notification.setStatus(resultSet.getString("status"));
					notification.setNotificationId(resultSet.getInt("notification_id"));

					// Additional job information
					Job job = new Job();
					job.setTitle(resultSet.getString("title"));
					job.setDescription(resultSet.getString("description"));
					job.setLocation(resultSet.getString("location"));

					// Additional user information
					User user = new User();
					user.setFirstName(resultSet.getString("firstname"));
					user.setLastName(resultSet.getString("lastname"));
					user.setEmail(resultSet.getString("email"));

					// Set the job and user for the notification
					AllModal allModal = new AllModal();
					allModal.setJob(job);
					allModal.setUser(user);
					allModal.setNotification(notification);

					notifications.add(allModal);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting notifications by applier ID: " + e.getMessage());
		}

		return notifications;
	}

	public boolean updateNotificationStatus(Notification notification) throws DAOException {
		String updateQuery = "UPDATE notification SET status = ? WHERE notification_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setString(1, notification.getStatus());
			statement.setInt(2, notification.getNotificationId());
			int rows = statement.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException("Error updating notification status: " + e.getMessage());
		}
	}
	
	
	public List<AllModal> getNotificationsByUserId(int userId) throws DAOException {
		List<AllModal> notifications = new ArrayList<>();

		String sql = "SELECT n.notification_id, n.applier_id, n.job_id, n.status, "
				+ "j.title, j.description, j.location, u.firstname, u.lastname,u.email " + "FROM notification n "
				+ "INNER JOIN job j ON n.job_id = j.jobid " + "INNER JOIN users u ON n.applier_id = u.user_id "
				+ "WHERE j.user_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, userId);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Notification notification = new Notification();
					notification.setApplierId(resultSet.getInt("applier_id"));
					notification.setJobId(resultSet.getString("job_id"));
					notification.setStatus(resultSet.getString("status"));
					notification.setNotificationId(resultSet.getInt("notification_id"));

					// Additional job information
					Job job = new Job();
					job.setTitle(resultSet.getString("title"));
					job.setDescription(resultSet.getString("description"));
					job.setLocation(resultSet.getString("location"));

					// Additional user information
					User user = new User();
					user.setFirstName(resultSet.getString("firstname"));
					user.setLastName(resultSet.getString("lastname"));
					user.setEmail(resultSet.getString("email"));

					// Set the job and user for the notification
					AllModal allModal = new AllModal();
					allModal.setJob(job);
					allModal.setUser(user);
					allModal.setNotification(notification);

					notifications.add(allModal);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting notifications by user ID: " + e.getMessage());
		}

 		return notifications;
	}
	
	
	public Notification getNotificationById(int Id) throws DAOException {
		Notification notifications = null;

		String sql = "SELECT job_id FROM notification WHERE notification_id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, Id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					notifications = new Notification();
					notifications.setJobId(resultSet.getString("job_id"));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting notifications by notification id ID: " + e.getMessage());
		}

 		return notifications;
	}

}
