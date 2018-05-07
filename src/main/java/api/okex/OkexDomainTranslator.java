package api.okex;

import api.ApiResponse;
import api.DomainEntity;
import api.JsonResponseReader;
import api.ResponseDomainTranslator;
import api.exception.ResponseNotSupportedException;
import api.okex.domain.Hydration.TickerHydrator;
import api.okex.domain.Hydration.exception.HydrationException;
import api.okex.response.GetTickerResponse;

public class OkexDomainTranslator implements ResponseDomainTranslator {
    @Override
    public DomainEntity translate(ApiResponse response) throws HydrationException, ResponseNotSupportedException {
        if (response instanceof GetTickerResponse) {
            return (new TickerHydrator()).hydrate((new JsonResponseReader()).toJsonObject(response.getData()));
        }

        throw new ResponseNotSupportedException(response);
    }
}
