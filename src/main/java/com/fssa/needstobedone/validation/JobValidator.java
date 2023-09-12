package com.fssa.needstobedone.validation;

import java.util.regex.Pattern;

import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.Job;

/**
 * Utility class for validating job-related data.
 */
public class JobValidator {

	/** 
	 * Validates a job object.
	 *
	 * @param job The job to be validated.
	 * @throws ValidationException If validation fails.
	 */
	public void validateJob(Job job) throws ValidationException {
		if (job != null && validateTitle(job.getTitle())) {
			validatePrice(job.getPrice()); 
		}
	}

	/**
	 * Validates a job title.
	 *
	 * @param title The job title to be validated.
	 * @return true if the title is valid, false otherwise.
	 * @throws ValidationException If validation fails.
	 */
	public static boolean validateTitle(String title) throws ValidationException {
		boolean match = false;

		if (title == null) {
			throw new ValidationException("Job title is not valid - job title cannot be empty");
		}

		String regex = "^[A-Za-z ]+$";
		match = Pattern.compile(regex).matcher(title).matches();

		if (!match) {
			throw new ValidationException(
					"Job title is not valid - Please enter a string containing only alphabetic characters (both uppercase and lowercase) and spaces.");
		}

		return true;
	}

	/**
	 * Validates a job price.
	 *
	 * @param price The job price to be validated.
	 * @return true if the price is valid, false otherwise.
	 * @throws ValidationException If validation fails.
	 */
	public static boolean validatePrice(int price) throws ValidationException {
		if (price == 0) {
			throw new ValidationException("Job Price is not valid - job price cannot be 0");
		}
		if (price < 0) {
			throw new ValidationException("Job Price is not valid - Price should be a positive number");
		}

		return true;
	}
}
