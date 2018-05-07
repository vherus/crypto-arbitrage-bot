package api.okex.request;

import api.ApiRequest;
import api.RequestMethod;
import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;

public class LimitBuyRequest implements ApiRequest {
    private CurrencyPair currencyPair;
    private BigDecimal price;
    private BigDecimal quantity;

    public LimitBuyRequest(CurrencyPair currencyPair, BigDecimal price, BigDecimal quantity) {
        this.currencyPair = currencyPair;
        this.price = price;
        this.quantity = quantity;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public RequestMethod getMethod() {
        return RequestMethod.POST;
    }

    @Override
    public String getUrl() {
        return "/trade.do";
    }
}
