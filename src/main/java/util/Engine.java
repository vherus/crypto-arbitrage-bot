package util;

import command.CommandBus;
import command.exception.CommandExecutionException;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.trade.LimitOrder;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

final public class Engine {
    final private CommandBus commandBus;

    @Inject
    public Engine(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    public void run(Integer transactionPercentage) throws IncompatibleCommandException, HandlerResolutionException, CommandExecutionException {
        List<LimitOrder> okexBook = ((OrderBook) commandBus.dispatch(new okex.command.GetOrderBookCommand(CurrencyPair.LTC_BTC))).getBids();
        List<LimitOrder> bittrexBook = ((OrderBook) commandBus.dispatch(new bittrex.command.GetOrderBookCommand(CurrencyPair.LTC_BTC))).getBids();
//        ArrayList<LimitOrder> mergedBook = OrderBookMerger.merge(okexBook, bittrexBook);

        // Default order books are ordered lowest price to highest
        Collections.reverse(okexBook);
        Collections.reverse(bittrexBook);

        LimitOrder bittrexTop = bittrexBook.get(0);
        LimitOrder okexTop = okexBook.get(0);

        BigDecimal fee = new BigDecimal(1 - (100 / transactionPercentage));

        String okexOrderId = (String) commandBus.dispatch(
                new okex.command.PlaceBuyOrderCommand(CurrencyPair.LTC_BTC, bittrexTop.getLimitPrice().multiply(fee), bittrexTop.getOriginalAmount())
        );

        String bittrexOrderId = (String) commandBus.dispatch(
                new bittrex.command.PlaceBuyOrderCommand(CurrencyPair.LTC_BTC, okexTop.getLimitPrice().multiply(fee), okexTop.getOriginalAmount())
        );

        // todo Check the status of each order every n seconds

        // if okex order is fulfilled...
        commandBus.dispatch(new bittrex.command.PlaceSellOrderCommand(CurrencyPair.LTC_BTC, bittrexTop.getLimitPrice(), bittrexTop.getOriginalAmount()));

        // if bittrex order is fulfilled...
        commandBus.dispatch(new okex.command.PlaceSellOrderCommand(CurrencyPair.LTC_BTC, okexTop.getLimitPrice(), okexTop.getOriginalAmount()));
    }
}
