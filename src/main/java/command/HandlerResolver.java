package command;

import command.exception.HandlerResolutionException;

final public class HandlerResolver {
    public static CommandHandler resolveHandler(Command command) throws HandlerResolutionException, RuntimeException {
        String name = command.getClass().getName();

        try {
            return (CommandHandler) Class.forName(name + "Handler").getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new HandlerResolutionException("Unable to resolve handler for command " + name);
        } catch (Throwable e) {
            throw new RuntimeException("Unexpected issue encountered during handler resolution", e);
        }
    }
}
