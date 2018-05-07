package api;

import api.exception.RequestNotSupportedException;

import java.io.IOException;

public interface ApiClient {
    ApiResponse send(ApiRequest apiRequest) throws RequestNotSupportedException, IOException;
}
