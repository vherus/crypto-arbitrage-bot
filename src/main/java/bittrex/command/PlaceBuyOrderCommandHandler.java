package bittrex.command;

import common.ApiComponent;
import common.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ExchangeContext;
import org.knowm.xchange.bittrex.BittrexExchange;

public class PlaceBuyOrderCommandHandler implements CommandHandler {
    private Component component;

    public PlaceBuyOrderCommandHandler() {
        component = new ApiComponent(new ExchangeContext(BittrexExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof PlaceBuyOrderCommand) {
            return handle((PlaceBuyOrderCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    private String handle(PlaceBuyOrderCommand command) throws CommandExecutionException {
        try {
            return component.placeBuyOrder(command.getCurrencyPair(), command.getLimitPrice(), command.getOriginalAmount());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
