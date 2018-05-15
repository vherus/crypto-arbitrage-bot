package command;

import com.google.inject.Injector;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;
import org.junit.jupiter.api.BeforeEach;
import registry.DependencyRegistry;

import static org.junit.jupiter.api.Assertions.*;


class HandlerResolverTest {
    private Injector injector;

    @BeforeEach
    void setUp() {
        injector = DependencyRegistry.boot();
    }

    @org.junit.jupiter.api.Test
    void resolveHandler() throws HandlerResolutionException {
        assertTrue(HandlerResolver.resolveHandler(new TestCommand("testname"), injector) instanceof TestCommandHandler);
    }

    @org.junit.jupiter.api.Test
    void resolveHandlerThrowsException() throws HandlerResolutionException {
        assertThrows(IncompatibleCommandException.class, () -> HandlerResolver.resolveHandler(new TestCommand("testname"), injector).handle(new InvalidTestCommand()));
    }
}
