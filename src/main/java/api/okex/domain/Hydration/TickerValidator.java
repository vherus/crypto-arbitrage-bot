package api.okex.domain.Hydration;

import api.okex.domain.Hydration.exception.HydrationException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;

class TickerValidator {
    void validate(JsonObject jsonObject) throws HydrationException {
        ArrayList<String> required = new ArrayList<String>(Arrays.asList(
                "buy",
                "high",
                "last",
                "low",
                "sell",
                "vol"
        ));

        for (String field : required) {
            if (!jsonObject.has(field)) {
                throw new HydrationException("JSON entity missing required field: " + field);
            }
        }
    }
}
