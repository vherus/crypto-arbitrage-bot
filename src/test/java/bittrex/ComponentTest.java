package bittrex;

import org.junit.jupiter.api.Test;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ComponentTest {

    @Test
    void getTicker() throws IOException {
        Component component = new Component();
        assertNotNull(component.getTicker(CurrencyPair.LTC_BTC));
    }
}
