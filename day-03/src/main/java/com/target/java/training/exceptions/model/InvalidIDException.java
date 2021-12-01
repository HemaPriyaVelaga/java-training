package com.target.java.training.exceptions.model;

// Dont write extends throwable
// Because throwable has both errors and exceptions
// and errors must not be handled by any application or developer
public class InvalidIDException extends RuntimeException {
    public InvalidIDException() {
    }

    public InvalidIDException(String message) {
        super(message);
        System.out.println(message);
    }

    public InvalidIDException(Throwable cause) {
        super(cause);
        System.out.println(cause);
    }
}
