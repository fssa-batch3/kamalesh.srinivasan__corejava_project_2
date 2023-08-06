package needsToBeDone.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import needsToBeDone.*;
import needsToBeDone.DAO.JobDAO;
import needsToBeDone.DAO.exceptions.DAOException;
import needsToBeDone.model.Job;
import needsToBeDone.validation.exceptions.InvalidUserException;

public class JobValidator {
	public static boolean validateJob(Job job) throws InvalidUserException {

		if (job != null && validateTitle(job.getTitle())&& validatePrice(job.getPrice()) && validateEmail(job.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("Job details not valid");
		}

	}


	public static boolean validateTitle(String title) {
		boolean match = false;

		if (title == null)
			return false;

		String regex = "^[A-Za-z ]+$";
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
	
	public static boolean validatePrice(int price) {
		boolean match = false;
		String S = String.valueOf(price);
		if(price == 0) {
			return false;
		}
		
		String regex = "^[+-]?\\d+$";
		match = Pattern.matches(regex,S);
		if(match) {
			System.out.println("the price is Valid");
		}else {
			System.out.println("the price is Invalid");
		}
		return match;
	}
	
	
	public static boolean validateEmail(String email) {
		
		JobDAO jobDAO = new JobDAO();
		
		
		boolean match = false;
	
		if(email == null) {
			return false;
		}
		
		try {
			match = jobDAO.checkEmail(email);
			if(match) {
				System.out.println("the Email is Valid");
			}else {
				System.out.println("the Email is Invalid");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return match;
	}
	
	
	
	
	
	
	


	
}
