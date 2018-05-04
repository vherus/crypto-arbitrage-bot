package command;

import command.exception.CommandExecutionException;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;

public interface CommandBus {
    Object dispatch(Command command) throws HandlerResolutionException, IncompatibleCommandException, CommandExecutionException;
}
