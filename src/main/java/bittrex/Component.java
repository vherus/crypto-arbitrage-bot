package bittrex;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.DefaultTradeHistoryParamCurrencyPair;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Component {
    private MarketDataService marketDataService;
    private TradeService tradeService;
    private AccountService accountService;

    public Component() {
        Exchange bittrex = ExchangeFactory.INSTANCE.createExchange(BittrexExchange.class.getName());
        marketDataService = bittrex.getMarketDataService();
        tradeService = bittrex.getTradeService();
        accountService = bittrex.getAccountService();
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

    public List<FundingRecord> getOrderHistory(CurrencyPair currencyPair) throws IOException {
        return accountService.getFundingHistory(new DefaultTradeHistoryParamCurrencyPair(currencyPair));
    }
}
