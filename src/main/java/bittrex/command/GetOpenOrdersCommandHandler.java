package bittrex.command;

import common.ApiComponent;
import common.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ExchangeContext;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.dto.trade.OpenOrders;

public class GetOpenOrdersCommandHandler implements CommandHandler {
    private Component component;

    public GetOpenOrdersCommandHandler() {
        component = new ApiComponent(new ExchangeContext(BittrexExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetOpenOrdersCommand) {
            return handle((GetOpenOrdersCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    private OpenOrders handle(GetOpenOrdersCommand command) throws CommandExecutionException {
        try {
            return component.getOpenOrders();
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
