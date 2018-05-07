package okex.command;

import api.exception.RequestNotSupportedException;
import api.exception.ResponseNotSupportedException;
import api.okex.domain.Hydration.exception.HydrationException;
import api.okex.domain.Order;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import okex.Component;

import java.io.IOException;

public class LimitBuyCommandHandler implements CommandHandler {
    private Component component;

    public LimitBuyCommandHandler() {
        component = new Component();
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof LimitBuyCommand) {
            try {
                return handle((LimitBuyCommand) command);
            } catch (Throwable e) {
                throw new CommandExecutionException(command, e);
            }
        }

        throw new IncompatibleCommandException(command, this);
    }

    private Order handle(LimitBuyCommand command) throws RequestNotSupportedException, HydrationException, ResponseNotSupportedException, IOException {
        return component.placeLimitBuyOrder(command.getCurrencyPair(), command.getPrice(), command.getQuantity());
    }
}
