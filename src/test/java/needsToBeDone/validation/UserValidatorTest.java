package needsToBeDone.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.validation.UserValidator;


public class UserValidatorTest {

	@Test
	public void testValidUser() {
		User user = new User("test@example.com", "Password123", "Kamalesh", "Srinivasan", true, 1234567890,
				LocalDate.of(1990, 1, 1), 123456789012L, "123 Main St");

		try {
			assertTrue(UserValidator.validateUser(user));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidUser() {
		User user = new User("invalid.email", "short", "123", "456", true, 123, LocalDate.of(2000, 1, 1), 123L, "123");

		try {
			assertFalse(UserValidator.validateUser(user));
		} catch (InvalidUserException e) {
			// Expected behavior for invalid user
		}
	}

	@Test
	public void testValidName() {
		assertTrue(UserValidator.validateName("Kamalesh"));
	}

	@Test
	public void testInvalidName() {
		assertFalse(UserValidator.validateName("123"));
	}

	@Test
	public void testValidPassword() {
		assertTrue(UserValidator.validatePassword("Password123!"));
	}

	@Test
	public void testInvalidPassword() {
		assertFalse(UserValidator.validatePassword("short"));
	}

	@Test
	public void testValidEmail() {
		assertTrue(UserValidator.validateEmail("test@example.com"));
	}

	@Test
	public void testInvalidEmail() {
		assertFalse(UserValidator.validateEmail("invalid.email"));
	}

	@Test
	public void testValidDOB() {
		assertTrue(UserValidator.validateDOB(LocalDate.of(1990, 1, 1)));
	}

	@Test
	public void testInvalidDOB() {
		assertFalse(UserValidator.validateDOB(LocalDate.of(2023, 1, 1)));
	}

	@Test
	public void testValidAadhar() {
		assertTrue(UserValidator.validateAadhar(123456789012L));
	}

	@Test
	public void testInvalidAadhar() {
		assertFalse(UserValidator.validateAadhar(123L));
	}

	@Test
	public void testValidPhoneNumber() {
		assertTrue(UserValidator.validatePhoneNumber(1234567890));
	}

	@Test
	public void testInvalidPhoneNumber() {
		assertFalse(UserValidator.validatePhoneNumber(123));
	}
}
