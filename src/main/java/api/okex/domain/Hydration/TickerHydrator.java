package api.okex.domain.Hydration;

import api.okex.domain.Hydration.exception.HydrationException;
import api.okex.domain.Ticker;
import com.google.gson.JsonObject;

public class TickerHydrator {
    public Ticker hydrate(JsonObject jsonObject) throws HydrationException {
        (new TickerValidator()).validate(jsonObject);

        return (new Ticker.Builder())
                .buy(jsonObject.get("buy").getAsBigDecimal())
                .high(jsonObject.get("high").getAsBigDecimal())
                .last(jsonObject.get("last").getAsBigDecimal())
                .low(jsonObject.get("low").getAsBigDecimal())
                .sell(jsonObject.get("sell").getAsBigDecimal())
                .vol(jsonObject.get("vol").getAsBigDecimal())
                .build();
    }
}
