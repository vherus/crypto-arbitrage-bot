package bittrex.command;

import bittrex.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import org.knowm.xchange.dto.marketdata.Ticker;

public class GetTickerCommandHandler implements CommandHandler {
    private Component component;

    public GetTickerCommandHandler(Component component) {
        this.component = component;
    }

    public void handle(Command command) throws IncompatibleCommandException {
        throw new IncompatibleCommandException(command, this);
    }

    public Ticker handle(GetTickerCommand command) throws CommandExecutionException {
        try {
            return component.getTicker(command.getCurrencyPair());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
