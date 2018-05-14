package common;

public class ExchangeContext {
    private String exchangeName;

    public ExchangeContext(String exchangeClassName) {
        exchangeName = exchangeClassName;
    }

    String getExchangeName() {
        return exchangeName;
    }
}
