package api.okex.response;

import api.ApiResponse;

import java.io.InputStream;

public class LimitBuyResponse implements ApiResponse {
    private InputStream data;

    public LimitBuyResponse(InputStream data) {
        this.data = data;
    }

    public InputStream getData() {
        return data;
    }
}
