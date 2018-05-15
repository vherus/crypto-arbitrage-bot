package bittrex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;
import org.knowm.xchange.dto.marketdata.Ticker;

import javax.inject.Inject;
import javax.inject.Named;

public class GetTickerCommandHandler implements CommandHandler {
    private final Component component;

    @Inject
    public GetTickerCommandHandler(@Named("Bittrex") Component component) {
        this.component = component;
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
