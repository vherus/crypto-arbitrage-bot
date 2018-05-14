package bittrex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;

import javax.inject.Named;

public class CancelOrderCommandHandler implements CommandHandler {
    private final Component component;

    public CancelOrderCommandHandler(@Named("Bittrex") Component component) {
        this.component = component;
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof CancelOrderCommand) {
            return handle((CancelOrderCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    public Boolean handle(CancelOrderCommand command) throws CommandExecutionException {
        try {
            return component.cancelOrder(command.getId());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
