package api;

import api.exception.RequestNotSupportedException;
import org.apache.http.HttpResponse;

import java.io.IOException;

public interface ApiResponseFactory {
    ApiResponse make(ApiRequest request, HttpResponse response) throws IOException, RequestNotSupportedException;
}
