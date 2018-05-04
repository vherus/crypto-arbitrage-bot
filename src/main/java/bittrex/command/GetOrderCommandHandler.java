package bittrex.command;

import bittrex.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import org.knowm.xchange.dto.Order;

public class GetOrderCommandHandler implements CommandHandler {
    private Component component;

    public GetOrderCommandHandler() {
        component = new Component();
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetOrderCommand) {
            return handle((GetOrderCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    public Order handle(GetOrderCommand command) throws CommandExecutionException {
        try {
            return component.getOrder(command.getId());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
