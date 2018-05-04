package okex;

import api.ApiClient;
import api.okex.OkexApiClient;
import api.okex.OkexApiContext;
import api.okex.request.GetTickerRequest;
import api.okex.response.GetTickerResponse;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;

public class Component {
    private ApiClient apiClient;

    public Component() {
        apiClient = new OkexApiClient(new OkexApiContext("", "", ""));
    }

    public Ticker getTicker(CurrencyPair currencyPair) {
        return ((GetTickerResponse) apiClient.send(new GetTickerRequest(currencyPair))).getTicker();
    }
}
