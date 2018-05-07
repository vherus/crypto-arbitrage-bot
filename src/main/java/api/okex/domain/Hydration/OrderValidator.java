package api.okex.domain.Hydration;

import api.okex.domain.Hydration.exception.HydrationException;
import com.google.gson.JsonObject;

class OrderValidator {
    void validate(JsonObject jsonObject) throws HydrationException {
        if (!jsonObject.has("order_id")) {
            throw new HydrationException("JSON entity missing required field: order_id");
        }
    }
}
