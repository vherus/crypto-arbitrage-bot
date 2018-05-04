package command;

import command.exception.IncompatibleCommandException;

public interface CommandHandler {
    void handle(Command command) throws IncompatibleCommandException;
}
