package com.felipeflohr.uno.exception;

public class NoAIBehaviourAssignedException extends RuntimeException {

    public NoAIBehaviourAssignedException() {}

    public NoAIBehaviourAssignedException(String message) {
        super(message);
    }

    public NoAIBehaviourAssignedException(Throwable cause) {
        super(cause);
    }

    public NoAIBehaviourAssignedException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
