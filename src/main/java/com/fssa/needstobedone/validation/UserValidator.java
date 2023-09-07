package com.fssa.needstobedone.validation;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.needstobedone.dao.UserDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.User;

public class UserValidator {
	
	public UserValidator() {
		// Default Constructor
	} 

	public static void validateUser(User user) throws ValidationException {

		if (user != null && validatePassword(user.getPassword()) && validateEmail(user.getEmail())
				&& validateName(user.getFirstName()) && validateName(user.getLastName())
				&& validateAadhar(user.getAadhar()) && validateDOB(user.getDOB())
				&& validatePhoneNumber(user.getPhoneNumber())) {
			validateAddress(user.getAddress());
		}
	}

	public static boolean validateName(String name) throws ValidationException {
		boolean match = false;
		if(name.trim().isEmpty()) {
			throw new ValidationException("Name is not valid - Name cannot be empty");
		}

		if (name == null) 
			return false;

		String regex = "^[A-Za-z]{1,30}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (!match) {
			throw new ValidationException(
					"Name is not valid - Name should have only letters (A-Z or a-z) and be 1 to 30 characters long.");
		}

		return match;
	}

	public static boolean validateAddress(String address) throws ValidationException {
		if (address.trim().isEmpty()) {
			throw new ValidationException("Name is not valid - Name cannot be empty");
		}
		if(address == null )
			return false;

		return true;
	}

	public static boolean validatePassword(String password) throws ValidationException {
		boolean match = false;
		
		if(password.isEmpty())
			throw new ValidationException("Password is not valid - Password cannot be empty");

		if (password == null)
			return false;

		String passwordPattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(passwordPattern, password);

		if (!match) {
			throw new ValidationException(
					"Password is not valid: Please ensure your password contains at least one lowercase letter, one uppercase letter, one digit, one special character (@#$%^&+=), one non-whitespace character, and is at least 8 characters long.");
		}

		return match; 
	}

	public static boolean validateEmail(String email) throws ValidationException {
		boolean isMatch = false;

		if (email == null)
			throw new ValidationException("Email is not valid - email cannot be empty");
		
		if(email.isEmpty())
			return false;
		
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (!isMatch) {
			throw new ValidationException("Email is not valid - email format should be example@gmail.com");
		}

		UserDAO userDAO = new UserDAO();
		try {
			if (!userDAO.checkUserByEmail(email))
				throw new ValidationException("Email already exist!!!");
		} catch (DAOException | ValidationException e) {
			throw new ValidationException(e.getMessage());
		}
		return isMatch;
	}

	public static boolean validateDOB(LocalDate date) throws ValidationException {

		if (date == null)
			throw new ValidationException("DateOfBirth is not valid - DateOfBirth cannot be empty");

		LocalDate currentDate = LocalDate.now();
		LocalDate minimumValidDob = currentDate.minus(Period.ofYears(15));
		if (date.isAfter(minimumValidDob)) {
			throw new ValidationException("DateOfBirth is not valid - your age should be greater than 15");
		} else {
			return true; 
		}
		

	}

	public static boolean validateAadhar(long aadhar) throws ValidationException {
		boolean isMatch = false;

		String aadharNumber = String.valueOf(aadhar);
		
		if(aadharNumber.trim().isEmpty())
			return false;
		
		if (aadharNumber == null)
			throw new ValidationException("Aadhar number is not valid - Aadhar number cannot be empty");
		String regex = "^\\d{12}$";
		isMatch = Pattern.matches(regex, aadharNumber);
		if (!isMatch) {
			throw new ValidationException("Aadhaar number is not valid - Aadhaar number should be a 12-digit number.");
		}
		return isMatch;

	}

	public static boolean validatePhoneNumber(long l) throws ValidationException {
		boolean isMatch = false;

		String phoneNumber = String.valueOf(l);
		

		if (phoneNumber == null)
			throw new ValidationException("Phone number is not valid - Phone number cannot be empty");
		
		if(phoneNumber.isEmpty())
			return false;
		
		String regex = "^\\d{10}$";
		isMatch = Pattern.matches(regex, phoneNumber);
		if (!isMatch) {
			throw new ValidationException("Phone number is not valid - Phone number should be a 10-digit number.");
		}
		return isMatch;

	}
	
	
	

}
