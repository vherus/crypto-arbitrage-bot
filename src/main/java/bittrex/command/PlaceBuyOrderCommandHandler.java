package bittrex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;

import javax.inject.Inject;
import javax.inject.Named;

public class PlaceBuyOrderCommandHandler implements CommandHandler {
    private final Component component;

    @Inject
    public PlaceBuyOrderCommandHandler(@Named("Bittrex") Component component) {
        this.component = component;
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
