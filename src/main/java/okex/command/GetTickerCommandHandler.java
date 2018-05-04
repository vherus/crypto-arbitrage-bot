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
    public Object handle(Command command) throws IncompatibleCommandException {
        if (command instanceof GetTickerCommand) {
            return handle((GetTickerCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    private Ticker handle(GetTickerCommand command) {
        return component.getTicker(command.getCurrencyPair());
    }
}
