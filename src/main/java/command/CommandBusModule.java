package command;

import com.google.inject.AbstractModule;

public class CommandBusModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CommandBus.class).to(SynchronousCommandBus.class);
    }
}
