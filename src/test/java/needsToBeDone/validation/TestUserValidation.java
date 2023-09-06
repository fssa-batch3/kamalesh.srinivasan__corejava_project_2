package needsToBeDone.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.validation.UserValidator;

public class TestUserValidation {

	 @Test
	    public void testValidateNameWithValidName() {
	        try {
	            UserValidator.validateName("JohnDoe");
	            assertTrue(true);
	        } catch (ValidationException e) {
	            fail("ValidationException occurred: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateNameWithInvalidName() {
	        try {
	            UserValidator.validateName("123");
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Name is not valid - Name should have only letters (A-Z or a-z) and be 1 to 30 characters long.", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateAddressWithValidAddress() {
	        try {
	            UserValidator.validateAddress("123 Main St");
	            assertTrue(true);
	        } catch (ValidationException e) {
	            fail("ValidationException occurred: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateAddressWithInvalidAddress() {
	        try {
	            UserValidator.validateAddress(null);
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Name is not valid - Name cannot be empty", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidatePasswordWithValidPassword() {
	        try {
	            UserValidator.validatePassword("Test@123");
	            assertTrue(true);
	        } catch (ValidationException e) {
	            fail("ValidationException occurred: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testValidatePasswordWithInvalidPassword() {
	        try {
	            UserValidator.validatePassword("weakpass");
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Password is not valid: Please ensure your password contains at least one lowercase letter, one uppercase letter, one digit, one special character (@#$%^&+=), one non-whitespace character, and is at least 8 characters long.", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateEmailWithValidEmail() {
	        try {
	            UserValidator.validateEmail("example@example.com");
	            assertTrue(true);
	        } catch (ValidationException e) {
	            fail("ValidationException occurred: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateEmailWithInvalidEmail() {
	        try {
	            UserValidator.validateEmail("invalid_email");
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Email is not valid - email format should be example@gmail.com", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateDOBWithValidDOB() {
	        try {
	            UserValidator.validateDOB(LocalDate.now().minusYears(20)); // Assuming the user is 20 years old
	            assertTrue(true);
	        } catch (ValidationException e) {
	            fail("ValidationException occurred: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateDOBWithInvalidDOB() {
	        try {
	            UserValidator.validateDOB(LocalDate.now());
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("DateOfBirth is not valid - your age should be greater than 15", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateAadharWithValidAadhar() {
	        try {
	            UserValidator.validateAadhar(123456789012L);
	            assertTrue(true);
	        } catch (ValidationException e) {
	            fail("ValidationException occurred: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateAadharWithInvalidAadhar() {
	        try {
	            UserValidator.validateAadhar(12345L);
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Aadhaar number is not valid - Aadhaar number should be a 12-digit number.", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidatePhoneNumberWithValidPhoneNumber() {
	        try {
	            UserValidator.validatePhoneNumber(1234567890L);
	            assertTrue(true);
	        } catch (ValidationException e) {
	            fail("ValidationException occurred: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testValidatePhoneNumberWithInvalidPhoneNumber() {
	        try {
	            UserValidator.validatePhoneNumber(12345L);
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Phone number is not valid - Phone number should be a 10-digit number.", e.getMessage());
	        }
	    }
	    
	    @Test
	    public void testValidateNameWithEmptyName() {
	        try {
	            UserValidator.validateName("");
	            fail("Expected ValidationException, but none was thrown"); 
	        } catch (ValidationException e) {
	            assertEquals("Name is not valid - Name should have only letters (A-Z or a-z) and be 1 to 30 characters long.", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateAddressWithEmptyAddress() {
	        try {
	            UserValidator.validateAddress("");
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Name is not valid - Name cannot be empty", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidatePasswordWithEmptyPassword() {
	        try {
	            UserValidator.validatePassword("");
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Password is not valid: Please ensure your password contains at least one lowercase letter, one uppercase letter, one digit, one special character (@#$%^&+=), one non-whitespace character, and is at least 8 characters long.", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateEmailWithEmptyEmail() {
	        try {
	            UserValidator.validateEmail("");
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Email is not valid - email format should be example@gmail.com", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateDOBWithEmptyDOB() {
	        try {
	            UserValidator.validateDOB(null);
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("DateOfBirth is not valid - DateOfBirth cannot be empty", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidateAadharWithEmptyAadhar() {
	        try {
	            UserValidator.validateAadhar(0L);
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Aadhaar number is not valid - Aadhaar number should be a 12-digit number.", e.getMessage());
	        }
	    }

	    @Test
	    public void testValidatePhoneNumberWithEmptyPhoneNumber() {
	        try {
	            UserValidator.validatePhoneNumber(0L);
	            fail("Expected ValidationException, but none was thrown");
	        } catch (ValidationException e) {
	            assertEquals("Phone number is not valid - Phone number should be a 10-digit number.", e.getMessage());
	        }
	    }
}