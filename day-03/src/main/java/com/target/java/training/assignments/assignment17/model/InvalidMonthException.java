package com.target.java.training.assignments.assignment17.model;

public class InvalidMonthException extends Exception {
    public InvalidMonthException() {
    }

    public InvalidMonthException(String message) {
        super(message);
        System.out.println(message);
    }

    public InvalidMonthException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message);
        System.out.println(cause);
    }
}
