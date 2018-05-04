package api.okex;

import api.ApiContext;

public class OkexApiContext implements ApiContext {
    private String baseUri;
    private String key;
    private String secret;

    public OkexApiContext(String baseUri, String key, String secret) {
        this.baseUri = baseUri;
        this.key = key;
        this.secret = secret;
    }

    @Override
    public String getBaseUri() {
        return baseUri;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getSecret() {
        return secret;
    }
}
