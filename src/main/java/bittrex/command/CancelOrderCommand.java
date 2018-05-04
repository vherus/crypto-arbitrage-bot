package bittrex.command;

import command.Command;

public class CancelOrderCommand implements Command {
    private String id;

    public CancelOrderCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
