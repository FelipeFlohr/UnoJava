package com.felipeflohr.unojava.exception;

/**
 * Exception that represents an Invalid Next Player
 * @author Felipe Matheus Flohr
 */
public class InvalidNextPlayer extends RuntimeException {

    public InvalidNextPlayer() {}

    public InvalidNextPlayer(String message) {
        super(message);
    }

    public InvalidNextPlayer(Throwable cause) {
        super(cause);
    }

    public InvalidNextPlayer(String message, Throwable cause) {
        super(message, cause);
    }
}
