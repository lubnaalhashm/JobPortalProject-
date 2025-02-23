package com.lubna.job_portal.Exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message) {
        super(message);
    }

    // Optional: Constructor with a custom message and a cause
    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
