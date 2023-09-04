package com.fssa.needstobedone.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.needstobedone.dao.JobDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.Job;

public class JobValidator {
	public static void validateJob(Job job) throws ValidationException {

		if (job != null && validateTitle(job.getTitle()) && validatePrice(job.getPrice())
				&& validateEmail(job.getEmail())) {
			
		} 

	}

	public static boolean validateTitle(String title) throws ValidationException {
		boolean match = false;

		if (title == null)
			throw new ValidationException("Job title is not valid - job title cannot be empty");
		String regex = "^[A-Za-z ]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(title);
		match = m.matches();
		if (!match) {
			throw new ValidationException(
					"Job title is not valid - Please enter a string containing only alphabetic characters (both uppercase and lowercase) and spaces.");
		}
		return match;
	}

	public static boolean validatePrice(int price) throws ValidationException {
		if (price == 0)
			throw new ValidationException("Job Price is not valid - job price cannot be 0");
		if (price < 0) {
			throw new ValidationException(
					"Job Price is not valid - Price should be in the format of a positive decimal number with two decimal places(10.99).");
		}
		return true;
	}

	public static boolean validateEmail(String email) throws ValidationException {

		JobDAO jobDAO = new JobDAO();

		boolean match = false;

		if (email == null)
			throw new ValidationException("Email is not valid - Email cannot be empty");

		try {
			match = jobDAO.checkEmail(email);
			if (!match) {
				throw new ValidationException("Email is not found");
			}
		} catch (DAOException e) {
			throw new ValidationException(e.getMessage());
		}

		return match;
	}

	public static boolean validateJobid(String jobid) throws ValidationException {

		JobDAO jobDAO = new JobDAO();

		boolean match = false;

		if (jobid == null)
			throw new ValidationException("JobId is not valid - JobId cannot be empty");

		try {
			match = jobDAO.checkJobId(jobid);
			if (!match) {
				throw new ValidationException("JobId is not found");
			}
		} catch (DAOException e) {
			throw new ValidationException(e.getMessage());
		}

		return match;
	}

}
