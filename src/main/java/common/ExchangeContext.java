package common;

public class ExchangeContext {
    private String exchangeName;

    public ExchangeContext(String exchangeClassName) {
        exchangeName = exchangeClassName;
    }

    public String getExchangeName() {
        return exchangeName;
    }
}
