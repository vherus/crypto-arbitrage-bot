package bittrex;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;
import java.math.BigDecimal;

public class Component {
    private MarketDataService marketDataService;
    private TradeService tradeService;

    public Component() {
        Exchange bittrex = ExchangeFactory.INSTANCE.createExchange(BittrexExchange.class.getName());
        marketDataService = bittrex.getMarketDataService();
        tradeService = bittrex.getTradeService();
    }

    public Ticker getTicker(CurrencyPair currencyPair) throws IOException {
        return marketDataService.getTicker(currencyPair);
    }

    public String placeBuyOrder(CurrencyPair currencyPair, BigDecimal limitPrice, BigDecimal originalAmount) throws IOException {
        return tradeService.placeLimitOrder(
                new LimitOrder.Builder(Order.OrderType.BID, currencyPair)
                    .limitPrice(limitPrice)
                    .originalAmount(originalAmount)
                    .build()
        );
    }

    public String placeSellOrder(CurrencyPair currencyPair, BigDecimal limitPrice, BigDecimal originalAmount) throws IOException {
        return tradeService.placeLimitOrder(
                new LimitOrder.Builder(Order.OrderType.ASK, currencyPair)
                    .limitPrice(limitPrice)
                    .originalAmount(originalAmount)
                    .build()
        );
    }

    public OpenOrders getOpenOrders() throws IOException {
        return tradeService.getOpenOrders();
    }
}
