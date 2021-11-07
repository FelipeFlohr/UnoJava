package com.felipeflohr.uno.exception;

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
