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
	void testValidateAddressWithValidAddress() {
		assertDoesNotThrow(() -> userValidator.validateAddress("123 Main St"));

	}

	@Test
	void testValidateAddressWithInvalidAddress() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateAddress(null));
		assertEquals("Address is not valid - Address cannot be empty", result.getMessage());
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
	void testValidateDOBWithValidDOB() {
		assertDoesNotThrow(() -> userValidator.validateDOB(LocalDate.now().minusYears(20)));

	}

	@Test
	void testValidateDOBWithInvalidDOB() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validateDOB(LocalDate.now()));

		assertEquals("DateOfBirth is not valid - your age should be greater than 15", result.getMessage());
	}

	@Test
	void testValidateAadharWithValidAadhar() {
		assertDoesNotThrow(() -> userValidator.validateAadhar(123456789012L));

	}

	@Test
	void testValidateAadharWithInvalidAadhar() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validateAadhar(12345L));

		assertEquals("Aadhaar number is not valid - Aadhaar number should be a 12-digit number.", result.getMessage());
	}

	@Test
	void testValidatePhoneNumberWithValidPhoneNumber() {
		assertDoesNotThrow(() -> userValidator.validatePhoneNumber(1234567890L));

	}

	@Test
	void testValidatePhoneNumberWithInvalidPhoneNumber() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validatePhoneNumber(12345L));
		assertEquals("Phone number is not valid - Phone number should be a 10-digit number.", result.getMessage());
	}

	@Test
	void testValidateNameWithEmptyName() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateName(""));

		assertEquals("Name is not valid - Name should have only letters (A-Z or a-z) and be 1 to 30 characters long.",
				result.getMessage());
	}

	@Test
	void testValidateAddressWithEmptyAddress() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateAddress(""));

		assertEquals("Address is not valid - Address cannot be empty", result.getMessage());
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

	@Test
	void testValidateDOBWithEmptyDOB() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateDOB(null));
		assertEquals("DateOfBirth is not valid - DateOfBirth cannot be empty", result.getMessage());
	}

	@Test
	void testValidateAadharWithEmptyAadhar() {
		ValidationException result = assertThrows(ValidationException.class, () -> userValidator.validateAadhar(0L));

		assertEquals("Aadhaar number is not valid - Aadhaar number should be a 12-digit number.", result.getMessage());
	}

	@Test
	void testValidatePhoneNumberWithEmptyPhoneNumber() {
		ValidationException result = assertThrows(ValidationException.class,
				() -> userValidator.validatePhoneNumber(0L));

		assertEquals("Phone number is not valid - Phone number should be a 10-digit number.", result.getMessage());
	}
}