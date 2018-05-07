package api.okex.request;

import api.ApiPostRequest;
import api.ApiRequest;
import api.RequestMethod;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class LimitBuyRequest implements ApiPostRequest {
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

    @Override
    public UrlEncodedFormEntity getParameters() throws UnsupportedEncodingException {
        ArrayList<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("symbol", this.currencyPair.toString().toLowerCase()));
        params.add(new BasicNameValuePair("type", "buy"));
        params.add(new BasicNameValuePair("price", this.price.toString()));
        params.add(new BasicNameValuePair("amount", this.quantity.toString()));

        return new UrlEncodedFormEntity(params, "UTF-8");
    }
}
