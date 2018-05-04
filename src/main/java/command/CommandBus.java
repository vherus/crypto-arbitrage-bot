package command;

import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;

public interface CommandBus {
    void dispatch(Command command) throws HandlerResolutionException, IncompatibleCommandException;
}
