package needsToBeDone.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.services.UserService;

public class TestRegistrationFeature {
	@Test
	public void testRegistrationSuccess() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		UserService userService = new UserService();
		User user1 = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh", "Srinivasan", true, 9876543210l,
				date, 123456789012l, "trichy");
		try {

			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}

	@Test
	public void testinvalidFirstName() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		UserService userService = new UserService();
		User user1 = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh23", "Srinivasan", true, 9876543210l,
				date, 123456789012l, "trichy");
		try {

			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testinvalidEmail() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		UserService userService = new UserService();
		User user1 = new User("kikamaklesgmail.commmm", "Kamalesh@1234", "Kamalesh", "Srinivasan", true, 9876543210l,
				date, 123456789012l, "trichy");
		try {

			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testinvalidLastName() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		UserService userService = new UserService();
		User user1 = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh", "Srinivasan23", true, 9876543210l,
				date, 123456789012l, "trichy");
		try {

			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testinvalidPhone() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		UserService userService = new UserService();
		User user1 = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh", "Srinivasan", true, 98765410l, date,
				123456789012l, "trichy");
		try {

			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testinvalidAadhar() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		UserService userService = new UserService();
		User user1 = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh", "Srinivasan", true, 98765410l, date,
				1234569012l, "trichy");
		try {

			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidPassword() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		UserService userService = new UserService();
		User user1 = new User("kidfadfza@gmail.com", "Kamal123k", "Kamalesh", "Srinivasan", true, 9876543210l, date,
				123456789012l, "trichy");
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
//		ServiceException exception = assertThrows(ServiceException.class, () -> userService.registerUser(user1));
//		assertEquals("Rethrown with a new message", exception.getMessage());
	}

	@Test
	public void testUserNull() {
		System.out.println("null");
		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testInValidDOB() {
		LocalDate date = LocalDate.now();
		UserService userService = new UserService();
		User user1 = new User("kidfadfza@gmail.com", "Kamal@123k", "Kamalesh", "Srinivasan", true, 9876543210l, date,
				123456789012l, "trichy");
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
