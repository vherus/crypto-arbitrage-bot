package api;

import api.exception.RequestNotSupportedException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.UnsupportedEncodingException;

public class HttpRequestFactory {
    public static HttpUriRequest makeHttpRequest(String baseUri, ApiRequest request) throws RequestNotSupportedException, UnsupportedEncodingException {
        String url = baseUri + request.getUrl();

        switch (request.getMethod()) {
            case GET:
                return new HttpGet(url);

            case POST:
                HttpPost httpPost = new HttpPost(url);

                if (request instanceof ApiPostRequest) {
                    httpPost.setEntity(((ApiPostRequest) request).getParameters());
                }

                return httpPost;
        }

        throw new RequestNotSupportedException(request);
    }
}
