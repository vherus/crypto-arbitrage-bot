package okex;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.okcoin.OkCoinExchange;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;
import java.math.BigDecimal;

public class Component {

    private MarketDataService marketDataService;
    private TradeService tradeService;
    private AccountService accountService;

    public Component() {
        Exchange okex = ExchangeFactory.INSTANCE.createExchange(OkCoinExchange.class.getName());
        marketDataService = okex.getMarketDataService();
        tradeService = okex.getTradeService();
        accountService = okex.getAccountService();
    }
}
