package bittrex.command;

import bittrex.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import org.knowm.xchange.dto.marketdata.Ticker;

public class GetTickerCommandHandler implements CommandHandler {
    private Component component;

    public GetTickerCommandHandler() {
        component = new Component();
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetTickerCommand) {
            return handle((GetTickerCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    private Ticker handle(GetTickerCommand command) throws CommandExecutionException {
        try {
            return component.getTicker(command.getCurrencyPair());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
