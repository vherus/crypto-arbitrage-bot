package command;

import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;

public class SynchronousCommandBus implements CommandBus {
    public void dispatch(Command command) throws HandlerResolutionException, IncompatibleCommandException {
        HandlerResolver.resolveHandler(command).handle(command);
    }
}
