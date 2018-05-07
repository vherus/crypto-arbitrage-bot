package api.exception;

import api.ApiRequest;

public class RequestNotSupportedException extends Exception {
    public RequestNotSupportedException(ApiRequest request) {
        super("ApiRequest not supported: " + request.getClass().getName());
    }
}
