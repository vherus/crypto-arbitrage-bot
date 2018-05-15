package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;
import org.knowm.xchange.dto.marketdata.OrderBook;

import javax.inject.Inject;
import javax.inject.Named;

public class GetOrderBookCommandHandler implements CommandHandler {
    private final Component component;

    @Inject
    public GetOrderBookCommandHandler(@Named("Okex") Component component) {
        this.component = component;
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
