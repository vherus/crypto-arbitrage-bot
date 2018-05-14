package common;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.OpenOrders;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface Component {
    Ticker getTicker(CurrencyPair currencyPair) throws IOException;
    String placeBuyOrder(CurrencyPair currencyPair, BigDecimal limitPrice, BigDecimal originalAmount) throws IOException;
    String placeSellOrder(CurrencyPair currencyPair, BigDecimal limitPrice, BigDecimal originalAmount) throws IOException;
    boolean cancelOrder(String orderId) throws IOException;
    OrderBook getOrderBook(CurrencyPair currencyPair) throws IOException;
    Order getOrder(String id) throws IOException;
    OpenOrders getOpenOrders() throws IOException;
    List<FundingRecord> getOrderHistory(CurrencyPair currencyPair) throws IOException;
}
