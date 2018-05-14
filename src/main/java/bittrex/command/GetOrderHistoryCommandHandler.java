package bittrex.command;

import common.ApiComponent;
import common.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ExchangeContext;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.dto.account.FundingRecord;

import java.util.List;

public class GetOrderHistoryCommandHandler implements CommandHandler {
    private Component component;

    public GetOrderHistoryCommandHandler() {
        component = new ApiComponent(new ExchangeContext(BittrexExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetOrderHistoryCommand) {
            return handle((GetOrderHistoryCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    public List<FundingRecord> handle(GetOrderHistoryCommand command) throws CommandExecutionException {
        try {
            return component.getOrderHistory(command.getCurrencyPair());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
