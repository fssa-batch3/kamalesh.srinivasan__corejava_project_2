package com.fssa.needstobedone.exception;

/**
 * Custom exception class for handling validation-related exceptions.
 */
public class ValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new ValidationException with the specified detail message.
     *
     * @param message The detail message describing the validation error.
     */
    public ValidationException(String message) {
        super(message);
    }
}
