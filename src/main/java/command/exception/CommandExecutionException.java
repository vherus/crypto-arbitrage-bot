package command.exception;

import command.Command;

public class CommandExecutionException extends Exception {
    public CommandExecutionException(Command command, Throwable e) {
        super("Error executing command " + command.getClass().getName(), e);
    }
}
