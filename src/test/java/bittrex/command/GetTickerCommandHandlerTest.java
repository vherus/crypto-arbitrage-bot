package bittrex.command;

import com.google.inject.Injector;
import command.CommandBus;
import command.HandlerResolver;
import command.SynchronousCommandBus;
import command.exception.CommandExecutionException;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.knowm.xchange.currency.CurrencyPair;
import registry.DependencyRegistry;

import static org.junit.jupiter.api.Assertions.*;

class GetTickerCommandHandlerTest {
    private CommandBus commandBus;
    private Injector injector;

    @BeforeEach
    void setUp() {
        injector = DependencyRegistry.boot();
        commandBus = injector.getInstance(CommandBus.class);
    }

    @Test
    void handle() {
        assertThrows(IncompatibleCommandException.class, () -> HandlerResolver.resolveHandler(new GetTickerCommand(CurrencyPair.LTC_BTC), injector).handle(new okex.command.GetTickerCommand(CurrencyPair.LTC_BTC)));
    }

    @Test
    void handleSpecificCommand() throws HandlerResolutionException, IncompatibleCommandException, CommandExecutionException {
        assertNotNull(commandBus.dispatch(new GetTickerCommand(CurrencyPair.LTC_BTC)));
    }
}
