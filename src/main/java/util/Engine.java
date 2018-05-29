package util;

import command.CommandBus;
import command.exception.CommandExecutionException;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.trade.LimitOrder;
import javax.inject.Inject;
import java.util.ArrayList;

final public class Engine {
    final private CommandBus commandBus;

    @Inject
    public Engine(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    public void run(Integer transactionPercentage) throws IncompatibleCommandException, HandlerResolutionException, CommandExecutionException {
        ArrayList<LimitOrder> orderBook = OrderBookMerger.merge(
            ((OrderBook) commandBus.dispatch(new okex.command.GetOrderBookCommand(CurrencyPair.LTC_BTC))).getBids(),
            ((OrderBook) commandBus.dispatch(new bittrex.command.GetOrderBookCommand(CurrencyPair.LTC_BTC))).getBids()
        );
    }
}
