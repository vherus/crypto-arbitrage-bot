package command;

import command.exception.CommandExecutionException;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;

public class SynchronousCommandBus implements CommandBus {
    public Object dispatch(Command command) throws HandlerResolutionException, IncompatibleCommandException, CommandExecutionException {
        return HandlerResolver.resolveHandler(command).handle(command);
    }
}
