package api.exception;

import api.ApiResponse;

public class ResponseNotSupportedException extends Exception {
    public ResponseNotSupportedException(ApiResponse response) {
        super("ApiResponse not supported: " + response.getClass().getName());
    }
}
