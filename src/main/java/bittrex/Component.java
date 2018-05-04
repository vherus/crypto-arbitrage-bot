package bittrex;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

public class Component {
    private MarketDataService marketDataService;

    public Component() {
        Exchange bittrex = ExchangeFactory.INSTANCE.createExchange(BittrexExchange.class.getName());
        marketDataService = bittrex.getMarketDataService();
    }

    public Ticker getTicker(CurrencyPair currencyPair) throws IOException {
        return marketDataService.getTicker(currencyPair);
    }
}
