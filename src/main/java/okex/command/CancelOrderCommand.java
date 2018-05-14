package okex.command;

import command.Command;

public class CancelOrderCommand implements Command {
    private String id;

    public CancelOrderCommand(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }
}
