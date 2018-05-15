package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;
import org.knowm.xchange.dto.trade.OpenOrders;

import javax.inject.Inject;
import javax.inject.Named;

public class GetOpenOrdersCommandHandler implements CommandHandler {
    private final Component component;

    @Inject
    public GetOpenOrdersCommandHandler(@Named("Okex") Component component) {
        this.component = component;
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
