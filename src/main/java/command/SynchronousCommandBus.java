package command;

import com.google.inject.Inject;
import com.google.inject.Injector;
import command.exception.CommandExecutionException;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;

public class SynchronousCommandBus implements CommandBus {
    final private Injector injector;

    @Inject
    public SynchronousCommandBus(Injector injector) {
        this.injector = injector;
    }

    public Object dispatch(Command command) throws HandlerResolutionException, IncompatibleCommandException, CommandExecutionException {
        return HandlerResolver.resolveHandler(command, injector).handle(command);
    }
}
