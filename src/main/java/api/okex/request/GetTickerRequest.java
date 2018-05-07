package api.okex.request;

import api.ApiRequest;
import api.RequestMethod;
import org.knowm.xchange.currency.CurrencyPair;

public class GetTickerRequest implements ApiRequest {
    private CurrencyPair currencyPair;

    public GetTickerRequest(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    public CurrencyPair getCurrencyPair() { // todo have a generic getQuery() or getParams() or something instead
        return currencyPair;
    }

    public RequestMethod getMethod() {
        return RequestMethod.GET;
    }

    public String getUrl() {
        return "/ticker";
    }
}
