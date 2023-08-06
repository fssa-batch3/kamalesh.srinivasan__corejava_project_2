package needsToBeDone.DAO;
import java.util.UUID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
	        String jobId = UUID.randomUUID().toString();
	         System.out.println(jobId);


			// Prepare SQL statement
			String insertQuery = "Insert INTO job (jobid,title,price,email ) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, jobId);
			statement.setString(2, job.getTitle());
			statement.setInt(3, job.getPrice());
			statement.setString(4,job.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
//	check the job is present in the job table 
	public boolean checkEmail(String email) throws DAOException {
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
				System.out.println("Valild");
			} else {
				System.out.println("Invalid Email");
			}

			resultSet.close();
			statement.close();
			connection.close();

			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}


}
