package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;

import javax.inject.Inject;
import javax.inject.Named;

public class PlaceSellOrderCommandHandler implements CommandHandler {
    private final Component component;

    @Inject
    public PlaceSellOrderCommandHandler(@Named("Okex") Component component) {
        this.component = component;
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
