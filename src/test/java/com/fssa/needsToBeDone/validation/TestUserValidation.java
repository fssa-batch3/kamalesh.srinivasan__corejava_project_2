package com.fssa.needsToBeDone.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.validation.UserValidator;

class TestUserValidation {

	UserValidator userValidator = new UserValidator();

	@Test
	void testValidateNameWithValidName() {
		assertDoesNotThrow(() -> userValidator.validateName("JohnDoe"));

	}

	@Test
	void testValidateNameWithInvalidName() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateName("123"));
		assertEquals("Name is not valid - Name should have only letters (A-Z or a-z) and be 1 to 30 characters long.",
				result.getMessage());
	}



	@Test
	void testValidatePasswordWithValidPassword() {
		assertDoesNotThrow(() -> userValidator.validatePassword("Test@123"));

	}

	@Test
	void testValidatePasswordWithInvalidPassword() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validatePassword("weakpass"));

		assertEquals("Password must contain at least one uppercase letter, one lowercase letter, and one digit",
				result.getMessage());
	}

	@Test
	void testValidateEmailWithValidEmail() {
		assertDoesNotThrow(() -> userValidator.validateEmail("example@example.com"));

	}

	@Test
	void testValidateEmailWithInvalidEmail() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validateEmail("invalid_email"));

		assertEquals("Email is not valid - email format should be example@gmail.com", result.getMessage());
	}





	@Test
	void testValidateNameWithEmptyName() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateName(""));

		assertEquals("Name is not valid - Name should have only letters (A-Z or a-z) and be 1 to 30 characters long.",
				result.getMessage());
	}


	@Test
	void testValidatePasswordWithEmptyPassword() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validatePassword(""));

		assertEquals(
				"Password cannot be empty",
				result.getMessage());
	}

	@Test
	void testValidateEmailWithEmptyEmail() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateEmail(""));
		assertEquals("Email is not valid - email format should be example@gmail.com", result.getMessage());
	}



}