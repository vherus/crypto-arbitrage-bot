package bittrex.command;

import command.Command;
import org.knowm.xchange.currency.CurrencyPair;

public class GetTickerCommand implements Command {
    private CurrencyPair currencyPair;

    public GetTickerCommand(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    CurrencyPair getCurrencyPair() {
        return currencyPair;
    }
}
