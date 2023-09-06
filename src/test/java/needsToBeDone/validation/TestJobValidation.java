package needsToBeDone.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.validation.JobValidator;

public class TestJobValidation {

    @Test
    public void testValidateTitleWithValidTitle() {
        try {
            JobValidator.validateTitle("FrontEnd Developer");
            assertTrue(true);
        } catch (ValidationException e) {
            fail("ValidationException occurred: " + e.getMessage());
        }
    }

    @Test
    public void testValidateTitleWithInvalidTitle() {
        ValidationException exception = assertThrows(ValidationException.class, () -> JobValidator.validateTitle("123"));
        assertEquals("Job title is not valid - Please enter a string containing only alphabetic characters (both uppercase and lowercase) and spaces.", exception.getMessage());
    }

    @Test
    public void testValidatePriceWithValidPrice() {
        try {
            JobValidator.validatePrice(100);
            assertTrue(true);
        } catch (ValidationException e) {
            fail("ValidationException occurred: " + e.getMessage());
        }
    }

    @Test
    public void testValidatePriceWithZeroPrice() {
        ValidationException exception = assertThrows(ValidationException.class, () -> JobValidator.validatePrice(0));
        assertEquals("Job Price is not valid - job price cannot be 0", exception.getMessage());
    }

    @Test
    public void testValidatePriceWithNegativePrice() {
        ValidationException exception = assertThrows(ValidationException.class, () -> JobValidator.validatePrice(-50));
        assertEquals("Job Price is not valid - Price should be in the format of a positive decimal number with two decimal places(10.99).", exception.getMessage());
    }

    @Test
    public void testValidateJobWithValidJob() {
        try {
            Job validJob = new Job("FrontEnd Developer", 100, null);
            JobValidator.validateJob(validJob);
            assertTrue(true);
        } catch (ValidationException e) {
            fail("ValidationException occurred: " + e.getMessage());
        }
    }

    @Test
    public void testValidateJobWithInvalidTitle() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            Job invalidJob = new Job("123", 100, null);
            JobValidator.validateJob(invalidJob);
        });
        assertEquals("Job title is not valid - Please enter a string containing only alphabetic characters (both uppercase and lowercase) and spaces.", exception.getMessage());
    }
 
    @Test
    public void testValidateJobWithZeroPrice() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            Job invalidJob = new Job("FrontEnd Developer", 0, null);
            JobValidator.validateJob(invalidJob);
        });
        assertEquals("Job Price is not valid - job price cannot be 0", exception.getMessage());
    }

    @Test
    public void testValidateJobWithNegativePrice() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
            Job invalidJob = new Job("FrontEnd Developer", -50, null);
            JobValidator.validateJob(invalidJob);
        });
        assertEquals("Job Price is not valid - Price should be in the format of a positive decimal number with two decimal places(10.99).", exception.getMessage());
    }
}