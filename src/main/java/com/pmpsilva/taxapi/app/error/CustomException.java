package com.pmpsilva.taxapi.app.error;

public class CustomException extends Exception {
    private static final long serialVersionUID = 2490632169435714046L;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

}
