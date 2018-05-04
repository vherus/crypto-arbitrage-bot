package command;

import command.exception.HandlerResolutionException;

import static org.junit.jupiter.api.Assertions.*;

class HandlerResolverTest {

    @org.junit.jupiter.api.Test
    void resolveHandler() throws HandlerResolutionException {
        assertTrue(HandlerResolver.resolveHandler(new TestCommand("testname")) instanceof TestCommandHandler);
    }
}
