package api.okex.domain.Hydration;

import api.okex.domain.Hydration.exception.HydrationException;
import api.okex.domain.Order;
import com.google.gson.JsonObject;

public class OrderHydrator {
    public Order hydrate(JsonObject jsonObject) throws HydrationException {
        (new OrderValidator()).validate(jsonObject);

        return new Order(jsonObject.get("order_id").getAsInt());
    }
}
