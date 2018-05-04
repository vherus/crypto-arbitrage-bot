package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.IncompatibleCommandException;
import okex.Component;
import org.knowm.xchange.dto.marketdata.Ticker;

public class GetTickerCommandHandler implements CommandHandler {
    private Component component;

    public GetTickerCommandHandler() {
        component = new Component();
    }

    @Override
    public void handle(Command command) throws IncompatibleCommandException {
        throw new IncompatibleCommandException(command, this);
    }

    public Ticker handle(GetTickerCommand command) {
        return component.getTicker(command.getCurrencyPair());
    }
}
