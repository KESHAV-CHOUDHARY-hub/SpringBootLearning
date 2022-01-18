package com.practice.hackathon.exception;

public class PlansNotAddedException extends Exception {
    public PlansNotAddedException() {
        super();
    }

    public PlansNotAddedException(String message) {
        super(message);
    }

    public PlansNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlansNotAddedException(Throwable cause) {
        super(cause);
    }

    protected PlansNotAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
