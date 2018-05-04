package command;

import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;

import static org.junit.jupiter.api.Assertions.*;


class HandlerResolverTest {

    @org.junit.jupiter.api.Test
    void resolveHandler() throws HandlerResolutionException {
        assertTrue(HandlerResolver.resolveHandler(new TestCommand("testname")) instanceof TestCommandHandler);
    }

    @org.junit.jupiter.api.Test
    void resolveHandlerThrowsException() throws HandlerResolutionException {
        assertThrows(IncompatibleCommandException.class, () -> {
            HandlerResolver.resolveHandler(new TestCommand("testname")).handle(new InvalidTestCommand());
        });
    }
}
