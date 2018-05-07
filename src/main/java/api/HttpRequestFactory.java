package api;

import api.exception.RequestNotSupportedException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestFactory {
    public static HttpUriRequest makeHttpRequest(String baseUri, ApiRequest request) throws RequestNotSupportedException {
        String url = baseUri + request.getUrl();

        switch (request.getMethod()) {
            case GET:
                return new HttpGet(url);

            case POST:
                return new HttpPost(url);
        }

        throw new RequestNotSupportedException(request);
    }
}
