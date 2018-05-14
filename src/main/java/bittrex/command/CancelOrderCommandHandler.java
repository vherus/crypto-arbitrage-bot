package bittrex.command;

import common.ApiComponent;
import common.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ExchangeContext;
import org.knowm.xchange.bittrex.BittrexExchange;

public class CancelOrderCommandHandler implements CommandHandler {
    private Component component;

    public CancelOrderCommandHandler() {
        component = new ApiComponent(new ExchangeContext(BittrexExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof CancelOrderCommand) {
            return handle((CancelOrderCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    public boolean handle(CancelOrderCommand command) throws CommandExecutionException {
        try {
            return component.cancelOrder(command.getId());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
