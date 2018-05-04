package command;

import command.exception.IncompatibleCommandException;

public class TestCommandHandler implements CommandHandler {
    public void handle(Command command) throws IncompatibleCommandException {
        throw new IncompatibleCommandException(command, this);
    }

    public void handle(TestCommand command) {
        System.out.print(command.getName());
    }
}
