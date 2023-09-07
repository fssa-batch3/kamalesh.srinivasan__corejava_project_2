package com.fssa.needstobedone.exception;

/**
 * Custom exception class for handling service-related exceptions.
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ServiceException with the specified detail message.
     *
     * @param msg The detail message.
     */
    public ServiceException(String msg) {
        super(msg);
    }
}
