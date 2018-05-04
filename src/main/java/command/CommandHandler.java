package command;

import command.exception.CommandExecutionException;
import command.exception.IncompatibleCommandException;

public interface CommandHandler {
    Object handle(Command command) throws IncompatibleCommandException, CommandExecutionException;
}
