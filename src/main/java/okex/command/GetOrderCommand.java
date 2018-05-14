package okex.command;

import command.Command;

public class GetOrderCommand implements Command {
    private String id;

    public GetOrderCommand(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }
}
