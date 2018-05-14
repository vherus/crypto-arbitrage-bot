package okex.command;

import command.Command;
import org.knowm.xchange.currency.CurrencyPair;

public class GetOrderBookCommand implements Command {
    private CurrencyPair currencyPair;

    public GetOrderBookCommand(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    CurrencyPair getCurrencyPair() {
        return currencyPair;
    }
}
