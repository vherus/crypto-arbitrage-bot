package bittrex.command;

import common.ApiComponent;
import common.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ExchangeContext;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.dto.marketdata.OrderBook;

public class GetOrderBookCommandHandler implements CommandHandler {
    private Component component;

    public GetOrderBookCommandHandler() {
        component = new ApiComponent(new ExchangeContext(BittrexExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetOrderBookCommand) {
            return handle((GetOrderBookCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    public OrderBook handle(GetOrderBookCommand command) throws CommandExecutionException {
        try {
            return component.getOrderBook(command.getCurrencyPair());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
