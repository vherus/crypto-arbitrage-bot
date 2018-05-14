package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ApiComponent;
import common.Component;
import common.ExchangeContext;
import org.knowm.xchange.okcoin.OkCoinExchange;

public class PlaceSellOrderCommandHandler implements CommandHandler {
    private Component component;

    public PlaceSellOrderCommandHandler() {
        component = new ApiComponent(new ExchangeContext(OkCoinExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof PlaceSellOrderCommand) {
            return handle((PlaceSellOrderCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    private String handle(PlaceSellOrderCommand command) throws CommandExecutionException {
        try {
            return component.placeSellOrder(command.getCurrencyPair(), command.getLimitPrice(), command.getOriginalAmount());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
