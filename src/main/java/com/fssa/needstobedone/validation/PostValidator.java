package com.fssa.needstobedone.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.Post;
import com.fssa.needstobedone.model.User;

public class PostValidator {

	public static boolean validatePost(Post post) throws ValidationException {

		if (post != null && validateTitle(post.getTitle()) && validateUser(post.getUser())) {
			return true;
		} else {
			throw new ValidationException("Post details not valid");
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

	public static boolean validateUser(User user) {
		boolean match = false;

		if (user == null) {
			System.out.println("User is cannot be null.");
		} else {
			System.out.println("User is valid.");
			match = true;
		}
		return match;
	}
}
