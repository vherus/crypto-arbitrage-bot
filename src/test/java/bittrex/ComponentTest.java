package bittrex;

import common.Component;
import common.ApiComponent;
import common.ExchangeContext;
import org.junit.jupiter.api.Test;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ComponentTest {

    @Test
    void getTicker() throws IOException {
        Component component = new ApiComponent(new ExchangeContext(BittrexExchange.class, "", ""));;
        assertNotNull(component.getTicker(CurrencyPair.LTC_BTC));
    }
}
