package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;
import org.knowm.xchange.dto.Order;

import javax.inject.Named;

public class GetOrderCommandHandler implements CommandHandler {
    private final Component component;

    public GetOrderCommandHandler(@Named("Okex") Component component) {
        this.component = component;
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
