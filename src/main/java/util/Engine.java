package util;

import command.CommandBus;

import javax.inject.Inject;

final public class Engine {
    final private CommandBus commandBus;

    @Inject
    public Engine(CommandBus commandBus) {
        this.commandBus = commandBus;
    }
}
