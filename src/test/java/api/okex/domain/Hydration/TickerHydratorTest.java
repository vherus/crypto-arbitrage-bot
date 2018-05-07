package api.okex.domain.Hydration;

import api.JsonResponseReader;
import api.okex.domain.Hydration.exception.HydrationException;
import api.okex.domain.Ticker;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TickerHydratorTest {

    @Test
    void hydrate() throws IOException, HydrationException {
        JsonResponseReader buffer = new JsonResponseReader();
        InputStream json = IOUtils.toInputStream("{\"date\":\"1410431279\",\"ticker\":{\"buy\":\"33.15\",\"high\":\"34.15\",\"last\":\"33.15\",\"low\":\"32.05\",\"sell\":\"33.16\",\"vol\":\"10532696.39199642\"}}", "UTF-8");
        JsonObject data = buffer.toJsonObject(json).get("ticker").getAsJsonObject();

        Ticker ticker = (new TickerHydrator()).hydrate(data);

        assertEquals("33.15", ticker.getBuy().toString());
        assertEquals("34.15", ticker.getHigh().toString());
        assertEquals("33.15", ticker.getLast().toString());
        assertEquals("32.05", ticker.getLow().toString());
        assertEquals("33.16", ticker.getSell().toString());
        assertEquals("10532696.39199642", ticker.getVol().toString());
    }
}
