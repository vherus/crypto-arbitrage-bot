package okex.command;

import api.exception.RequestNotSupportedException;
import api.exception.ResponseNotSupportedException;
import api.okex.domain.Hydration.exception.HydrationException;
import api.okex.domain.Ticker;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import okex.Component;

import java.io.IOException;

public class GetTickerCommandHandler implements CommandHandler {
    private Component component;

    public GetTickerCommandHandler() {
        component = new Component();
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetTickerCommand) {
            try {
                return handle((GetTickerCommand) command);
            } catch (Throwable e) {
                throw new CommandExecutionException(command, e);
            }
        }

        throw new IncompatibleCommandException(command, this);
    }

    private Ticker handle(GetTickerCommand command) throws RequestNotSupportedException, ResponseNotSupportedException, HydrationException, IOException {
        return component.getTicker(command.getCurrencyPair());
    }
}
