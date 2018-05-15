package okex.command;

import command.Command;
import command.CommandHandler;
import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;
import common.Component;
import org.knowm.xchange.dto.account.FundingRecord;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class GetOrderHistoryCommandHandler implements CommandHandler {
    private final Component component;

    @Inject
    public GetOrderHistoryCommandHandler(@Named("Okex") Component component) {
        this.component = component;
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
