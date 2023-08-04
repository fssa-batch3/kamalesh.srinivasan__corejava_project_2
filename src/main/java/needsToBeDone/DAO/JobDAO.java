package needsToBeDone.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import needsToBeDone.DAO.exceptions.DAOException;
import needsToBeDone.model.Job;
import needsToBeDone.model.User;

public class JobDAO {
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/needstobedone", "root", "root");
		return connection;

	}
	
	
	public boolean createJob(Job job) throws DAOException {

		
		
		
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO job (title,location, price, summary, qualification,responsibilities,email) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, job.getTitle());
			statement.setString(2, job.getLocation());
			statement.setInt(3, job.getPrice());
			statement.setString(4, job.getSummary());
			statement.setString(5, job.getQualification());
			statement.setString(6,job.getResponsibilities());
			statement.setString(7,job.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}


}
