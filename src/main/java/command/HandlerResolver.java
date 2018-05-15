package command;

import com.google.inject.Injector;
import command.exception.HandlerResolutionException;

final public class HandlerResolver {
    public static CommandHandler resolveHandler(Command command, Injector injector) throws HandlerResolutionException, RuntimeException {
        String name = command.getClass().getName();

        try {
            return (CommandHandler) injector.getInstance(Class.forName(name + "Handler"));
        } catch (ClassNotFoundException e) {
            throw new HandlerResolutionException("Unable to resolve handler for command " + name);
        } catch (Throwable e) {
            throw new RuntimeException("Unexpected issue encountered during handler resolution", e);
        }
    }
}
