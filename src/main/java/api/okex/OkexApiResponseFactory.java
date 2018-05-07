package api.okex;

import api.ApiRequest;
import api.ApiResponse;
import api.ApiResponseFactory;
import api.exception.RequestNotSupportedException;
import api.okex.request.GetTickerRequest;
import api.okex.response.GetTickerResponse;
import org.apache.http.HttpResponse;

import java.io.IOException;

public class OkexApiResponseFactory implements ApiResponseFactory {

    @Override
    public ApiResponse make(ApiRequest request, HttpResponse response) throws IOException, RequestNotSupportedException {
        if (request instanceof GetTickerRequest) {
            return new GetTickerResponse(response.getEntity().getContent());
        }

        throw new RequestNotSupportedException(request);
    }
}
