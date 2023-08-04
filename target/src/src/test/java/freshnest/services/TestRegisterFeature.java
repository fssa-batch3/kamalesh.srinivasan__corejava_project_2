package freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import freshnest.model.User;
import freshnest.services.UserService;
import freshnest.services.exceptions.ServiceException;

public class TestRegisterFeature {

	public static void main(String[] args) {

		User user1 = new User("mani@gmail.com", "Kani_Papa", "susi123@SM", "Susikumar", "Pitchaimuthu");
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("Susikumar@gmail.com", "IamSusi", "susi123@SM", "Susikumar", "Pitchaimuthu");
		try {

			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("Susikumar@gmail.com", "IamSusi", "susi123SM", "Susikumar", "Pitchaimuthu");
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

}
