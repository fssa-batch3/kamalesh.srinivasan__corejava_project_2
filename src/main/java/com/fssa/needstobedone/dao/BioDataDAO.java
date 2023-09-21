package com.fssa.needstobedone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.model.BioData;
import com.fssa.needstobedone.utils.ConnectionUtil;

public class BioDataDAO {

    public boolean createBioData(int userId, BioData bioData) throws DAOException {
        String query = "INSERT INTO BioData (userId, firstName, lastName, dob, expertIn, phoneNumber, aadharNumber, upi, occupation, education, skills, address, comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, userId);
            pst.setString(2, bioData.getFirstName());
            pst.setString(3, bioData.getLastName());
            pst.setDate(4, bioData.getDob());
            pst.setString(5, bioData.getExpertIn());
            pst.setString(6, bioData.getPhoneNumber());
            pst.setString(7, bioData.getAadharNumber());
            pst.setString(8, bioData.getUpi());
            pst.setString(9, bioData.getOccupation());
            pst.setString(10, String.join(", ", bioData.getEducation())); // Join education array if needed
            pst.setString(11, bioData.getSkills());
            pst.setString(12, bioData.getAddress());
            pst.setString(13, bioData.getComments());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
