package needsToBeDone.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import needsToBeDone.model.Job;
import needsToBeDone.validation.exceptions.InvalidUserException;

public class JobValidator {
	public static boolean validateJob(Job job) throws InvalidUserException {

		if (job != null && validateTitle(job.getTitle())
				&& validateLocation(job.getLocation())) {
			return true;
		} else {
			throw new InvalidUserException("Job details not valid");
		}

	}


	public static boolean validateTitle(String title) {
		boolean match = false;

		if (title == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(title);
		match = m.matches();
		if (match) {
			System.out.println("The title name is valid.");
		} else {
			System.out.println("The title name is not valid");
		}

		return match;
	}

//	public static boolean validateQualification(String data) {
//		boolean match = false;
//
//		if (data == null)
//			return false;
//
//		String pattern_string = "^(?=(.*[.].*){2,})(?=(.*[A-Za-z].*){51,}).*$";
//		match = Pattern.matches(pattern_string, data);
//
//		if (match) {
//
//			System.out.println("Valid Qualification.");
//		} else {
//			System.out.println("Invalid Qualification.");
//		}
//
//		return match;
//	}
//	
//	
//	public static boolean validateResponsibilities(String data) {
//		boolean match = false;
//
//		if (data == null)
//			return false;
//
//		String pattern_string = "^(?=(.*[.].*){2,})(?=(.*[A-Za-z].*){51,}).*$";
//		match = Pattern.matches(pattern_string, data);
//
//		if (match) {
//
//			System.out.println("Valid Responsibilities.");
//		} else {
//			System.out.println("Invalid Responsibilities.");
//		}
//
//		return match;
//	}
//	
//	
//	public static boolean validateSummary(String data) {
//		boolean match = false;
//
//		if (data == null)
//			return false;
//
//		String pattern_string = "^(?=(.*[.].*){2,})(?=(.*[A-Za-z].*){51,}).*$";
//		match = Pattern.matches(pattern_string, data);
//
//		if (match) {
//
//			System.out.println("Valid Summary.");
//		} else {
//			System.out.println("Invalid Summary.");
//		}
//
//		return match;
//	}

	public static boolean validateLocation(String location) {
		boolean isMatch = false;

		if (location == null)
			return false;
		String regex = "^(.{6,49})$";
		isMatch = Pattern.matches(regex, location);
		if (isMatch) {
			System.out.println("The location is: Valid");
		} else {
			System.out.println("The location is: Invalid");
		}
		return isMatch;

	}
}
