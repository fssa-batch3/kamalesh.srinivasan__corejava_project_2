package needsToBeDone.validation;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import needsToBeDone.model.User;
import needsToBeDone.validation.exceptions.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {

		if (user != null && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) && validateName(user.getFirstName())&& validateName(user.getLastName())&& validateAadhar(user.getAadhar())&& validateDOB(user.getDOB())&& validatePhoneNumber(user.getPhoneNumber())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// Checking the loginUser present or not

	public static boolean validateLogIn(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");

		}
	}

	public static boolean validateName(String name) {
		boolean match = false;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]{1,30}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The name is valid.");
		} else {
			System.out.println("The name is not valid");
		}

		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;

		if (password == null)
			return false;

		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The Email is: Valid");
		} else {
			System.out.println("The Email is: Invalid");
		}
		return isMatch;

	}

	public static boolean validateDOB(LocalDate date) {
		boolean isMatch = false;

		String Date = date.toString();

		if (Date == null)
			return false;
		String regex = "^(?:19[3-9]\\d|200[0-9]|201[0-9]|202[0-2])[- /.](?:0[1-9]|1[0-2])[- /.](?:0[1-9]|[12][0-9]|3[01])$";
		isMatch = Pattern.matches(regex, Date);
		if (isMatch) {
			System.out.println("The DOB is: Valid");
		} else {
			System.out.println("The DOB is: Invalid");
		}
		return isMatch;

	}

	public static boolean validateAadhar(long aadhar) {
		boolean isMatch = false;

		String Aadhar = String.valueOf(aadhar);
		if (Aadhar == null)
			return false;
		String regex = "^\\d{12}$";
		isMatch = Pattern.matches(regex, Aadhar);
		if (isMatch) {
			System.out.println("The Aadhar is: Valid");
		} else {
			System.out.println("The Aadhar is: Invalid");
		}
		return isMatch;

	}

	public static boolean validatePhoneNumber(long l) {
		boolean isMatch = false;

		String Phone = String.valueOf(l);

		if (Phone == null)
			return false;
		String regex = "^\\d{10}$";
		isMatch = Pattern.matches(regex, Phone);
		if (isMatch) {
			System.out.println("The Phone Number is: Valid");
		} else {
			System.out.println("The Phone Number is: Invalid");
		}
		return isMatch;

	}

}
