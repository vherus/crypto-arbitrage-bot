package okex;

import api.ApiClient;
import api.exception.RequestNotSupportedException;
import api.exception.ResponseNotSupportedException;
import api.okex.OkexApiClient;
import api.okex.OkexApiContext;
import api.okex.OkexDomainTranslator;
import api.okex.domain.Hydration.exception.HydrationException;
import api.okex.domain.Ticker;
import api.okex.request.GetTickerRequest;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

public class Component {
    private ApiClient apiClient;
    private OkexDomainTranslator domainTranslator;

    public Component() {
        apiClient = new OkexApiClient(new OkexApiContext("", "", ""));
        domainTranslator = new OkexDomainTranslator();
    }

    public Ticker getTicker(CurrencyPair currencyPair) throws RequestNotSupportedException, IOException, ResponseNotSupportedException, HydrationException {
        return (Ticker) domainTranslator.translate(apiClient.send(new GetTickerRequest(currencyPair)));
    }
}
