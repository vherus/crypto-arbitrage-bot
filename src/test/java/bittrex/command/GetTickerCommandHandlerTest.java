package bittrex.command;

import command.HandlerResolver;
import command.SynchronousCommandBus;
import command.exception.CommandExecutionException;
import command.exception.HandlerResolutionException;
import command.exception.IncompatibleCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.knowm.xchange.currency.CurrencyPair;

import static org.junit.jupiter.api.Assertions.*;

class GetTickerCommandHandlerTest {
    SynchronousCommandBus commandBus;

    @BeforeEach
    void setUp() {
        commandBus = new SynchronousCommandBus();
    }

    @Test
    void handle() {
        assertThrows(IncompatibleCommandException.class, () -> HandlerResolver.resolveHandler(new GetTickerCommand(CurrencyPair.LTC_BTC)).handle(new okex.command.GetTickerCommand(CurrencyPair.LTC_BTC)));
    }

    @Test
    void handleSpecificCommand() throws HandlerResolutionException, IncompatibleCommandException, CommandExecutionException {
        assertNotNull(commandBus.dispatch(new GetTickerCommand(CurrencyPair.LTC_BTC)));
    }
}
