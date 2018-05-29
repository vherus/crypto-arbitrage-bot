package common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.okcoin.OkCoinExchange;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OkexApiComponentIntegrationTest {
    private Component component;

    @BeforeEach
    void setUp() {
        component = new ApiComponent(
            new ExchangeContext(OkCoinExchange.class, "", "", "")
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

    @Test
    void orderBooksAreOrderedByLowestPriceFirst() throws IOException {
        OrderBook book = component.getOrderBook(CurrencyPair.LTC_BTC);
        List<LimitOrder> asks = book.getAsks();
        Collections.reverse(asks);

        LimitOrder previous = asks.get(0);
        assertNotNull(previous);

        for (LimitOrder ask : asks.subList(1, asks.size())) {
            assertTrue(ask.getLimitPrice().compareTo(previous.getLimitPrice()) < 0);
            previous = ask;
        }
    }
}
