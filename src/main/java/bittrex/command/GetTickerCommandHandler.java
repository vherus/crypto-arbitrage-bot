package bittrex.command;

import common.ApiComponent;
import common.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ExchangeContext;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.dto.marketdata.Ticker;

public class GetTickerCommandHandler implements CommandHandler {
    private Component component;

    public GetTickerCommandHandler() {
        component = new ApiComponent(new ExchangeContext(BittrexExchange.class.getName()));
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
