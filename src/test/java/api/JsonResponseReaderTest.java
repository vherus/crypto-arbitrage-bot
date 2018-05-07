package api;

import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

class JsonResponseReaderTest {

    @Test
    void read() throws IOException {
        JsonResponseReader buffer = new JsonResponseReader();
        InputStream json = IOUtils.toInputStream("{\"date\":\"1410431279\",\"ticker\":{\"buy\":\"33.15\",\"high\":\"34.15\",\"last\":\"33.15\",\"low\":\"32.05\",\"sell\":\"33.16\",\"vol\":\"10532696.39199642\"}}", "UTF-8");
        JsonObject data = buffer.toJsonObject(json);

        assertEquals("1410431279", data.get("date").getAsString());
        assertEquals("33.15", data.get("ticker").getAsJsonObject().get("buy").getAsString());
        assertEquals("34.15", data.get("ticker").getAsJsonObject().get("high").getAsString());
        assertEquals("33.15", data.get("ticker").getAsJsonObject().get("last").getAsString());
        assertEquals("32.05", data.get("ticker").getAsJsonObject().get("low").getAsString());
        assertEquals("33.16", data.get("ticker").getAsJsonObject().get("sell").getAsString());
        assertEquals("10532696.39199642", data.get("ticker").getAsJsonObject().get("vol").getAsString());
    }
}
