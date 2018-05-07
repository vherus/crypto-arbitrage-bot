package api.okex;

import api.ApiClient;
import api.ApiRequest;
import api.ApiResponse;
import api.HttpRequestFactory;
import api.exception.RequestNotSupportedException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class OkexApiClient implements ApiClient {
    private OkexApiContext context;
    private HttpClient httpClient;

    public OkexApiClient(OkexApiContext context) {
        this.context = context;
        httpClient = HttpClientBuilder.create().build();
    }

    @Override
    public ApiResponse send(ApiRequest apiRequest) throws RequestNotSupportedException, IOException {
        HttpUriRequest httpRequest = HttpRequestFactory.makeHttpRequest(context.getBaseUri(), apiRequest);

        return (new OkexApiResponseFactory()).make(apiRequest, httpClient.execute(httpRequest));
    }
}
