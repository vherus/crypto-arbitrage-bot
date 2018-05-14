package bittrex.command;

import common.ApiComponent;
import common.Component;
import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.ExchangeContext;
import org.knowm.xchange.bittrex.BittrexExchange;
import org.knowm.xchange.dto.Order;

public class GetOrderCommandHandler implements CommandHandler {
    private Component component;

    public GetOrderCommandHandler() {
        component = new ApiComponent(new ExchangeContext(BittrexExchange.class.getName()));
    }

    @Override
    public Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException {
        if (command instanceof GetOrderCommand) {
            return handle((GetOrderCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    public Order handle(GetOrderCommand command) throws CommandExecutionException {
        try {
            return component.getOrder(command.getId());
        } catch (Throwable e) {
            throw new CommandExecutionException(command, e);
        }
    }
}
