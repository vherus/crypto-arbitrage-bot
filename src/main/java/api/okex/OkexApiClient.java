package api.okex;

import api.ApiClient;
import api.ApiRequest;
import api.ApiResponse;
import api.okex.response.GetTickerResponse;

public class OkexApiClient implements ApiClient {
    private OkexApiContext context;

    public OkexApiClient(OkexApiContext context) {
        this.context = context;
    }

    @Override
    public ApiResponse send(ApiRequest apiRequest) {
        // todo Implement API logic
        return new GetTickerResponse();
    }
}
