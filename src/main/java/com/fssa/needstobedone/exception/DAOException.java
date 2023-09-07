package com.fssa.needstobedone.exception;

/**
 * Custom exception class for handling data access related exceptions in the DAO layer.
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new DAOException with the specified detail message.
     *
     * @param msg The detail message.
     */
    public DAOException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new DAOException with the specified throwable as the cause.
     *
     * @param e The throwable that caused this exception.
     */
    public DAOException(Throwable e) {
        super(e);
    }
}
