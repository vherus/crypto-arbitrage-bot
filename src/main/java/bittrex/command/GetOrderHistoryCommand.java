package bittrex.command;

import command.Command;
import org.knowm.xchange.currency.CurrencyPair;

public class GetOrderHistoryCommand implements Command {
    private CurrencyPair currencyPair;

    public GetOrderHistoryCommand(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    CurrencyPair getCurrencyPair() {
        return currencyPair;
    }
}
