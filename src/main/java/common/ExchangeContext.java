package common;

import org.knowm.xchange.Exchange;

public class ExchangeContext {
    private final Class<? extends Exchange> exchange;
    private final String apiKey;
    private final String secret;
    private final String username;

    public ExchangeContext(Class<? extends Exchange> exchange, String apiKey, String secret) {
        this.exchange = exchange;
        this.apiKey = apiKey;
        this.secret = secret;
        this.username = "";
    }

    public ExchangeContext(Class<? extends Exchange> exchange, String apiKey, String secret, String username) {
        this.exchange = exchange;
        this.apiKey = apiKey;
        this.secret = secret;
        this.username = username;
    }

    Class<? extends Exchange> getExchange() {
        return exchange;
    }

    String getApiKey() {
        return apiKey;
    }

    String getSecret() {
        return secret;
    }

    String getUsername() {
        return username;
    }
}
