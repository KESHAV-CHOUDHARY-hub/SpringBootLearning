package com.practice.hackathon.exception;

public class MobileNumbersNotAddedException extends Exception {
    public MobileNumbersNotAddedException() {
        super();
    }

    public MobileNumbersNotAddedException(String message) {
        super(message);
    }

    public MobileNumbersNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MobileNumbersNotAddedException(Throwable cause) {
        super(cause);
    }

    protected MobileNumbersNotAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
