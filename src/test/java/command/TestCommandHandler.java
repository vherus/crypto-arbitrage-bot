package command;

import command.exception.IncompatibleCommandException;

public class TestCommandHandler implements CommandHandler {
    public Object handle(Command command) throws IncompatibleCommandException {
        if (command instanceof TestCommand) {
            return handle((TestCommand) command);
        }

        throw new IncompatibleCommandException(command, this);
    }

    private String handle(TestCommand command) {
        return command.getName();
    }
}
