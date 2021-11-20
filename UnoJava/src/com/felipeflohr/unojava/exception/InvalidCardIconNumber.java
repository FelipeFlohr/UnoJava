package com.felipeflohr.unojava.exception;

/**
 * Exception that represents an Invalid Card Icon Number
 * @author Felipe Matheus Flohr
 */
public class InvalidCardIconNumber extends RuntimeException {

    public InvalidCardIconNumber() {}

    public InvalidCardIconNumber(String message) {
        super(message);
    }

    public InvalidCardIconNumber(Throwable cause) {
        super(cause);
    }

    public InvalidCardIconNumber(String message, Throwable cause) {
        super(message, cause);
    }
    
}
