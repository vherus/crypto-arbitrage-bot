package util;

import org.junit.jupiter.api.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderBookMergerTest {

    @Test
    void merge() {
        ArrayList<LimitOrder> bookOne = new ArrayList<>();
        ArrayList<LimitOrder> bookTwo = new ArrayList<>();

        bookOne.add(new LimitOrder(Order.OrderType.ASK, new BigDecimal(0.0), CurrencyPair.LTC_BTC, "fourth", new Date(), new BigDecimal(0.5475)));
        bookOne.add(new LimitOrder(Order.OrderType.ASK, new BigDecimal(0.0), CurrencyPair.LTC_BTC, "second", new Date(), new BigDecimal(0.7475)));
        bookTwo.add(new LimitOrder(Order.OrderType.ASK, new BigDecimal(0.0), CurrencyPair.LTC_BTC, "third", new Date(), new BigDecimal(0.6475)));
        bookTwo.add(new LimitOrder(Order.OrderType.ASK, new BigDecimal(0.0), CurrencyPair.LTC_BTC, "first", new Date(), new BigDecimal(0.8475)));

        ArrayList<LimitOrder> merged = OrderBookMerger.merge(bookOne, bookTwo);

        assertEquals(4, merged.size());
        assertEquals("first", merged.get(0).getId());
        assertEquals("second", merged.get(1).getId());
        assertEquals("third", merged.get(2).getId());
        assertEquals("fourth", merged.get(3).getId());
    }
}
