package needsToBeDone.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import needsToBeDone.model.User;
import needsToBeDone.services.UserService;
import needsToBeDone.services.exceptions.ServiceException;

public class TestLoginFeature {

	public static void main(String[] args) {

		User user1 = new User("kikamakles@gmail.com", "Kamal@123");
		UserService userService = new UserService();

		try {
			userService.logInUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test
	public void testInvalidUser() {

		UserService userService = new UserService();
		User user1 = new User("utichi@gmail.com", "Utchi@123");
		try {
			Assertions.assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
