package bittrex.command;

import bittrex.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import org.knowm.xchange.dto.trade.OpenOrders;

public class GetOpenOrdersCommandHandler implements CommandHandler {
    private Component component;

    public GetOpenOrdersCommandHandler() {
        component = new Component();
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetOpenOrdersCommand) {
            return handle((GetOpenOrdersCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    private OpenOrders handle(GetOpenOrdersCommand command) throws CommandExecutionException {
        try {
            return component.getOpenOrders();
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
