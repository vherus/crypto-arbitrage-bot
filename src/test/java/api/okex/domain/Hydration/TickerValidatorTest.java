package api.okex.domain.Hydration;

import api.JsonResponseReader;
import api.okex.domain.Hydration.exception.HydrationException;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TickerValidatorTest {

    @Test
    void validate() throws IOException, HydrationException {
        JsonResponseReader buffer = new JsonResponseReader();
        InputStream json = IOUtils.toInputStream("{\"date\":\"1410431279\",\"ticker\":{\"buy\":\"33.15\",\"high\":\"34.15\",\"last\":\"33.15\",\"low\":\"32.05\",\"sell\":\"33.16\",\"vol\":\"10532696.39199642\"}}", "UTF-8");
        JsonObject data = buffer.toJsonObject(json).get("ticker").getAsJsonObject();

        TickerValidator validator = new TickerValidator();
        validator.validate(data);

        data.remove("high");
        assertThrows(HydrationException.class, () -> {
            validator.validate(data);
        });
    }
}
