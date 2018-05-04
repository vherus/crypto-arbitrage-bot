package okex.command;

import command.Command;
import org.knowm.xchange.currency.CurrencyPair;

public class GetTickerCommand implements Command {
    private CurrencyPair currencyPair;

    public GetTickerCommand(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }
}
