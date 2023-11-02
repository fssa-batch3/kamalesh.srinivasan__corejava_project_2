package com.fssa.needsToBeDone.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.validation.JobValidator;

class TestJobValidation {

	JobValidator jobValidator = new JobValidator();

	@Test
	void testValidateTitleWithValidTitle() {
		try {
			jobValidator.validateTitle("FrontEnd Developer");
			assertTrue(true);
		} catch (ValidationException e) {
			fail("ValidationException occurred: " + e.getMessage());
		}
	}

	@Test
	void testValidateTitleWithInvalidTitle() {
		ValidationException exception = assertThrows(ValidationException.class,
				() -> jobValidator.validateTitle("123"));
		assertEquals(
				"Job title is not valid - should contain alphabets and be up to 30 characters long",
				exception.getMessage());
	}

	@Test
	void testValidatePriceWithValidPrice() {
		try {
			jobValidator.validatePrice(100);
			assertTrue(true);
		} catch (ValidationException e) {
			fail("ValidationException occurred: " + e.getMessage());
		}
	}

	@Test
	void testValidatePriceWithZeroPrice() {
		ValidationException exception = assertThrows(ValidationException.class, () -> jobValidator.validatePrice(0));
		assertEquals("Job Price is not valid - Price should be a positive number", exception.getMessage());
	}
 
	@Test
	void testValidatePriceWithNegativePrice() {
		ValidationException exception = assertThrows(ValidationException.class, () -> jobValidator.validatePrice(-50));
		assertEquals("Job Price is not valid - Price should be a positive number", exception.getMessage());
	}

	@Test
	void testValidateJobWithValidJob() {
		try {
			Job validJob = new Job("FrontEnd Developer", "chennai", 10000, "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", 5);
			jobValidator.validateJob(validJob);
			assertTrue(true);
			} catch (ValidationException e) {
			fail("ValidationException occurred: " + e.getMessage());
		}
	}

	@Test
	void testValidateJobWithInvalidTitle() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			jobValidator.validateJob(new Job("123", "chennai", 10000, "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", 5));
		});
		assertEquals(
				"Job title is not valid - should contain alphabets and be up to 30 characters long",
				exception.getMessage());
	}

	@Test
	void testValidateJobWithNullTitle() {
		ValidationException exception = assertThrows(ValidationException.class,
				() -> jobValidator.validateJob(new Job(null, "chennai", 10000, "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", 5)));
		assertEquals("Job title is not valid - title cannot be empty", exception.getMessage());
	}

	@Test 
	void testValidateJobWithZeroPrice() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			jobValidator.validateJob(new Job("FrontEnd Developer", "chennai", 0, "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", 5));
		});
		assertEquals("Job Price is not valid - Price should be a positive number", exception.getMessage());
	}

	@Test
	void testValidateJobWithNegativePrice() {
		ValidationException exception = assertThrows(ValidationException.class, () -> {
			jobValidator.validateJob(new Job("FrontEnd Developer","chennai", -10000, "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", 5));
		});
		assertEquals("Job Price is not valid - Price should be a positive number", exception.getMessage());
	}
}