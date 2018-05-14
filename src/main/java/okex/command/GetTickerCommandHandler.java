package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ApiComponent;
import common.Component;
import common.ExchangeContext;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.okcoin.OkCoinExchange;

public class GetTickerCommandHandler implements CommandHandler {
    private Component component;

    public GetTickerCommandHandler() {
        component = new ApiComponent(new ExchangeContext(OkCoinExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof okex.command.GetTickerCommand) {
            return handle((okex.command.GetTickerCommand) command);
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
