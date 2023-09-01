package needsToBeDone.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.services.UserService;

public class TestLoginFeature {
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

	@Test
	public void testInvalidEmail() {

		UserService userService = new UserService();
		User user1 = new User("utichi@gmail.com", "Utchi@123");
		try {
			Assertions.assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("utichi@gmail.com", "Utchiii@123");
		try {
			Assertions.assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
