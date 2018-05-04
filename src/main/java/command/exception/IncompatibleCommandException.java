package command.exception;

import command.Command;
import command.CommandHandler;

public class IncompatibleCommandException extends Exception {
    public IncompatibleCommandException(Command command, CommandHandler handler) {
        super(handler.getClass().getName() + " does not support " + command.getClass().getName());
    }
}
