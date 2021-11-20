package com.felipeflohr.unojava.exception;

/**
 * Exception that represents an Invalid Card Number
 * @author Felipe Matheus Flohr
 */
public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException() {}

    public InvalidNumberException(String message) {
        super(message);
    }

    public InvalidNumberException(Throwable cause) {
        super(cause);
    }

    public InvalidNumberException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
