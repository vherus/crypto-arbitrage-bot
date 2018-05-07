package api.okex.response;

import api.ApiResponse;

import java.io.InputStream;

public class GetTickerResponse implements ApiResponse {
    private InputStream data;

    public GetTickerResponse(InputStream data) {
        this.data = data;
    }

    public InputStream getData() {
        return data;
    }
}
