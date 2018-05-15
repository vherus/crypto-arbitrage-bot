package common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BittrexApiComponentIntegrationTest {
    private Component component;

    @BeforeEach
    void setUp() {
        component = new ApiComponent(
                new ExchangeContext(BittrexExchange.class, "e6cf7534e81d4ce49bc214006bae0c5a", "d54a9496685041ae973f0ba193fa250d")
        );
    }

    @Test
    void getTicker() throws IOException {
        Ticker ticker = component.getTicker(CurrencyPair.LTC_BTC);
        assertEquals(CurrencyPair.LTC_BTC, ticker.getCurrencyPair());
    }

    @Test
    void getOrderBook() throws IOException {
        OrderBook book = component.getOrderBook(CurrencyPair.LTC_BTC);
        List<LimitOrder> orders = book.getOrders(Order.OrderType.ASK);

        for (Order order : orders) {
            assertEquals(CurrencyPair.LTC_BTC, order.getCurrencyPair());
        }
    }
}